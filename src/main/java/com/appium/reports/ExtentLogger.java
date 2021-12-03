package com.appium.reports;

import com.appium.constants.FrameworkConstants;
import com.appium.utils.ConfigLoader;
import com.appium.utils.ScreenshotUtils;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.markuputils.Markup;

public final class ExtentLogger {

	private ExtentLogger() {
	}

	public static void pass(String message) {
		ExtentManager.getExtentTest().pass(message);
	}

	public static void pass(Markup message) {
		ExtentManager.getExtentTest().pass(message);
	}

	public static void fail(String message) {
		ExtentManager.getExtentTest().fail(message);
	}

	public static void fail(Markup message) {
		ExtentManager.getExtentTest().fail(message);
	}

	public static void skip(String message) {
		ExtentManager.getExtentTest().skip(message);
	}

	public static void skip(Markup message) {
		ExtentManager.getExtentTest().skip(message);
	}

	public static void info(Markup message) {
		ExtentManager.getExtentTest().info(message);
	}

	public static void info(String message) {
		ExtentManager.getExtentTest().info(message);
	}

	public static void pass(String message, boolean isScreeshotNeeded) {
		if (ConfigLoader.getInstance().getPassedStepsScreenshot().equalsIgnoreCase(FrameworkConstants.YES)
				&& isScreeshotNeeded) {
			ExtentManager.getExtentTest().pass(message,
					MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getBase64Image()).build());
		} else {
			pass(message);
		}
	}

	public static void pass(Markup message, boolean isScreeshotNeeded) {
		// if
		// (PropertyUtils.get(ConfigProperties.PASSED_STEPS_SCREENSHOT).equalsIgnoreCase("yes")
		// && isScreeshotNeeded) {
		if (ConfigLoader.getInstance().getPassedStepsScreenshot().equalsIgnoreCase(FrameworkConstants.YES)
				&& isScreeshotNeeded) {
			/*
			 * ExtentManager.getExtentTest().pass(message,
			 * MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.
			 * getBase64Image()).build());
			 */
			ExtentManager.getExtentTest().pass(
					MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getBase64Image()).build());
			ExtentManager.getExtentTest().pass(message);
		} else {
			pass(message);
		}
	}

	public static void fail(String message, boolean isScreeshotNeeded) {
		// if
		// (PropertyUtils.get(ConfigProperties.FAILED_STEPS_SCREENSHOT).equalsIgnoreCase("yes")
		// && isScreeshotNeeded) {
		if (ConfigLoader.getInstance().getFailedStepsScreenshot().equalsIgnoreCase(FrameworkConstants.YES)
				&& isScreeshotNeeded) {
			ExtentManager.getExtentTest().fail(message,
					MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getBase64Image()).build());
		} else {
			fail(message);
		}
	}

	public static void fail(Markup message, boolean isScreeshotNeeded) {
		// if
		// (PropertyUtils.get(ConfigProperties.FAILED_STEPS_SCREENSHOT).equalsIgnoreCase("yes")
		// && isScreeshotNeeded) {
		if (ConfigLoader.getInstance().getFailedStepsScreenshot().equalsIgnoreCase(FrameworkConstants.YES)
				&& isScreeshotNeeded) {
			/*
			 * ExtentManager.getExtentTest().fail(message,
			 * MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.
			 * getBase64Image()).build());
			 */
			ExtentManager.getExtentTest().fail(
					MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getBase64Image()).build());
			ExtentManager.getExtentTest().fail(message);
		} else {
			fail(message);
		}
	}

	public static void skip(String message, boolean isScreeshotNeeded) {
		// if
		// (PropertyUtils.get(ConfigProperties.SKIPPED_STEPS_SCREENSHOT).equalsIgnoreCase("yes")
		// && isScreeshotNeeded) {
		if (ConfigLoader.getInstance().getSkippedStepsScreenshot().equalsIgnoreCase(FrameworkConstants.YES)
				&& isScreeshotNeeded) {
			ExtentManager.getExtentTest().skip(message,
					MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getBase64Image()).build());
		} else {
			skip(message);
		}
	}

	public static void skip(Markup message, boolean isScreeshotNeeded) {
		// if
		// (PropertyUtils.get(ConfigProperties.SKIPPED_STEPS_SCREENSHOT).equalsIgnoreCase("yes")
		// && isScreeshotNeeded) {
		if (ConfigLoader.getInstance().getSkippedStepsScreenshot().equalsIgnoreCase(FrameworkConstants.YES)
				&& isScreeshotNeeded) {
			/*
			 * ExtentManager.getExtentTest().skip(message,
			 * MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.
			 * getBase64Image()).build());
			 */

			ExtentManager.getExtentTest().skip(
					MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getBase64Image()).build());
			ExtentManager.getExtentTest().skip(message);
		} else {
			skip(message);
		}
	}

}
