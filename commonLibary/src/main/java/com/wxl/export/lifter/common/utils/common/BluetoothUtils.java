package com.wxl.export.lifter.common.utils.common;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

public class BluetoothUtils
{
	public static TheGetBlueToothDeviceBroadcastReceiver theGetBlueToothDeviceBroadcastReceiver = null;
	public static TheFinishScanningBlueToothDeviceBroadcastReceiver theFinishScanningBlueToothDeviceBroadcastReceiver = null;
	public static List<BluetoothDevice> theScanningBluetoothDevice = null;

	private BluetoothUtils()
	{
		/* cannot be instantiated */
		throw new UnsupportedOperationException("cannot be instantiated");
	}

	/**
	 * 检测当前设备是否支持蓝牙功能
	 * 
	 * @return
	 */
	public static boolean isThisMahionSupportBluetooth()
	{
		BluetoothAdapter ba = BluetoothAdapter.getDefaultAdapter();
		if (null != ba)
		{
			return true;
		}
		return false;
	}

	/**
	 * 检测蓝牙是否打开
	 * 
	 * @return
	 */
	public static boolean isBluetoothHadOpen()
	{
		if (isThisMahionSupportBluetooth())
		{
			BluetoothAdapter ba = BluetoothAdapter.getDefaultAdapter();
			if (ba.isEnabled())
			{
				return true;
			}
		}
		return false;
	}

	/**
	 * 打开蓝牙
	 * 
	 * @param context
	 */
	public static void jumpToOpenBluetooth(Context context)
	{
		if (isThisMahionSupportBluetooth() && !isBluetoothHadOpen())
		{
			Intent intent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
			context.startActivity(intent);// 或者ba.enable();
											// //同样的关闭WIFi为ba.disable();
		}
	}

	/**
	 * 获得已经配对蓝牙设备列表
	 * 
	 * @return
	 */
	public static Set<BluetoothDevice> getBluetoothDevice()
	{
		if (isThisMahionSupportBluetooth() && isBluetoothHadOpen())
		{
			BluetoothAdapter ba = BluetoothAdapter.getDefaultAdapter();
			Set<BluetoothDevice> device = ba.getBondedDevices();
			if (device.size() > 0)
			{
				for (BluetoothDevice bd : device)
				{
					System.out.println(bd.getAddress() + bd.getName());
				}
			}
			return device;
		}
		return null;
	}

	/**
	 * 设置蓝牙的可见时间，以便被其他设备发现并连接
	 * 
	 * @param context
	 *            上下文变量
	 * @param asignTime
	 *            这个值么默认120秒，超过300秒将会被设置为300.可是在我的设备上是2400也行。API出错？
	 * @return
	 */
	public static boolean setBluetoothCanAsignTime(Context context, int asignTime)
	{
		if (isThisMahionSupportBluetooth())
		{
			try
			{
				Intent intentvisible = new Intent(BluetoothAdapter.ACTION_REQUEST_DISCOVERABLE);

				intentvisible.putExtra(BluetoothAdapter.EXTRA_DISCOVERABLE_DURATION, asignTime);
				// 这个值么默认120秒，超过300秒将会被设置为300.可是在我的设备上是2400也行。API出错？
				context.startActivity(intentvisible);
				return true;
			} catch (Exception e)
			{
				// TODO: handle exception
				return false;
			}
		}
		return false;

	}

	/**
	 * 开始扫描的代码
	 * 
	 * @return
	 */
	public static boolean startScanningDevice(Context context)
	{
		if (isThisMahionSupportBluetooth() && isBluetoothHadOpen())
		{
			BluetoothAdapter ba = BluetoothAdapter.getDefaultAdapter();
			ba.startDiscovery();
			registGetBlueToothDeviceBroadcastReceiver(context);
			registFinishScanningBlueToothDeviceBroadcastReceiver(context);
			return true;
		}
		return false;
	}

	/**
	 * 获取扫描到的设备
	 * 
	 * @param context
	 * @return
	 */
	public static List<BluetoothDevice> getScanningDevice(Context context)
	{
		if (isThisMahionSupportBluetooth() && isBluetoothHadOpen() && theScanningBluetoothDevice != null)
		{
			return theScanningBluetoothDevice;
		}
		return null;
	}

	// ======================================相关广播操作===============================================start
	public static void registGetBlueToothDeviceBroadcastReceiver(Context context)
	{
		IntentFilter intentfilter = new IntentFilter(BluetoothDevice.ACTION_FOUND);
		theGetBlueToothDeviceBroadcastReceiver = new TheGetBlueToothDeviceBroadcastReceiver();
		context.registerReceiver(theGetBlueToothDeviceBroadcastReceiver, intentfilter);
	}

	public static void unregistGetBlueToothDeviceBroadcastReceiver(Context context)
	{
		if (theGetBlueToothDeviceBroadcastReceiver != null)
		{
			context.unregisterReceiver(theGetBlueToothDeviceBroadcastReceiver);
		}
	}

	public static void registFinishScanningBlueToothDeviceBroadcastReceiver(Context context)
	{
		IntentFilter intentfilter = new IntentFilter(BluetoothDevice.ACTION_FOUND);
		theFinishScanningBlueToothDeviceBroadcastReceiver = new TheFinishScanningBlueToothDeviceBroadcastReceiver();
		context.registerReceiver(theGetBlueToothDeviceBroadcastReceiver, intentfilter);
	}

	public static void unregistFinishScanningBlueToothDeviceBroadcastReceiver(Context context)
	{
		if (theFinishScanningBlueToothDeviceBroadcastReceiver != null)
		{
			context.unregisterReceiver(theFinishScanningBlueToothDeviceBroadcastReceiver);
		}
	}

	static class TheGetBlueToothDeviceBroadcastReceiver extends BroadcastReceiver
	{

		@Override
		public void onReceive(Context context, Intent intent)
		{
			if (theScanningBluetoothDevice == null)
			{
				theScanningBluetoothDevice = new ArrayList<BluetoothDevice>();
			}
			BluetoothDevice bd = intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);
			theScanningBluetoothDevice.add(bd);
			System.out.println(" bd.getName():" + bd.getName());
		}
	}

	static class TheFinishScanningBlueToothDeviceBroadcastReceiver extends BroadcastReceiver
	{

		@Override
		public void onReceive(Context context, Intent intent)
		{
			unregistGetBlueToothDeviceBroadcastReceiver(context);
			unregistFinishScanningBlueToothDeviceBroadcastReceiver(context);
		}

	}
	// ======================================相关广播操作===============================================end
}
