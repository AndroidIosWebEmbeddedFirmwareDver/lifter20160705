package com.wxl.export.lifter.common.widget.view;

import android.view.animation.Interpolator;

/**
 * 
 * @Desc: 插值器
 * @com.wxl.export.lifter.common.widget.view
 * @HuiyuantongVenusMobileCash-V3.x
 * @DecelerateAccelerateInterpolator.java
 * @Author:Wxl@Sintn.Inc
 * @2015-6-24下午5:03:47
 */
public class DecelerateAccelerateInterpolator implements Interpolator
{
	private float mFactor = 1.0f;

	public DecelerateAccelerateInterpolator()
	{
	}

	public DecelerateAccelerateInterpolator(float factor)
	{
		mFactor = factor;
	}

	public float getInterpolation(float input)
	{
		// y=2x^2+2x+1
		// y=-x^2/2+x/2

		float result;
		if (input < 0.5)
		{
			result = (float) (1.0f - Math.pow((1.0f - 2 * input), 2 * mFactor)) / 2;
		} else
		{
			result = (float) Math.pow((input - 0.5) * 2, 2 * mFactor) / 2 + 0.5f;
		}
		return result;
	}
}