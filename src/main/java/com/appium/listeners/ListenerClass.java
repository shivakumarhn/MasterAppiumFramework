package com.appium.listeners;

import java.util.Arrays;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import static com.appium.constants.FrameworkConstants.ICON_SMILEY_FAIL;
import static com.appium.constants.FrameworkConstants.ICON_SMILEY_PASS;
import static com.appium.constants.FrameworkConstants.ICON_BUG;

import com.appium.annotations.FrameworkAnnotation;
import com.appium.reports.ExtentLogger;
import com.appium.reports.ExtentReport;
import com.appium.utils.EmailSendUtils;
import com.appium.utils.ZipUtils;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;

public class ListenerClass implements ITestListener, ISuiteListener {

	static int count_passedTCs;
	static int count_skippedTCs;
	static int count_failedTCs;
	static int count_totalTCs;

	public void onStart(ISuite suite) {
		ExtentReport.initReports();
	}

	public void onFinish(ISuite suite) {
		ExtentReport.flushReports();
		ZipUtils.zip();
		EmailSendUtils.sendEmail(count_totalTCs, count_passedTCs, count_failedTCs, count_skippedTCs);
	}

	public void onTestStart(ITestResult result) {

		// System.out.println("onTestStart() ");
		count_totalTCs = count_totalTCs + 1;
		ExtentReport.createTest(result.getMethod().getMethodName());
		// ExtentReport.createTest(result.getMethod().getDescription());

		ExtentReport.addAuthors(result.getMethod().getConstructorOrMethod().getMethod()
				.getAnnotation(FrameworkAnnotation.class).author());

		ExtentReport.addCategories(result.getMethod().getConstructorOrMethod().getMethod()
				.getAnnotation(FrameworkAnnotation.class).category());

		ExtentReport.addDevices();
		// ExtentLogger.info("<b>" +
		// BrowserOSInfoUtils.getOS_Browser_BrowserVersionInfo() + "</b>");

	}

	public void onTestSuccess(ITestResult result) {
		count_passedTCs = count_passedTCs + 1;

		String logText = "<b>" + result.getMethod().getMethodName() + " is passed.</b>" + "  " + ICON_SMILEY_PASS;
		Markup markup_message = MarkupHelper.createLabel(logText, ExtentColor.GREEN);
		// ExtentLogger.pass(markup_message, true);
		ExtentLogger.pass(markup_message);

	}

	public void onTestFailure(ITestResult result) {
		count_failedTCs = count_failedTCs + 1;
		ExtentLogger.fail(ICON_BUG + "  " + "<b><i>" + result.getThrowable().toString() + "</i></b>");
		String exceptionMessage = Arrays.toString(result.getThrowable().getStackTrace());
	
		String message = "<details><summary><b><font color=red> Exception occured, click to see details: "
				+ ICON_SMILEY_FAIL + " </font></b>" + "</summary>" + exceptionMessage.replaceAll(",", "<br>")
				+ "</details> \n";
		ExtentLogger.fail(message);
		
		String logText = "<b>" + result.getMethod().getMethodName() + " is failed.</b>" + "  " + ICON_SMILEY_FAIL;
		Markup markup_message = MarkupHelper.createLabel(logText, ExtentColor.RED);
		ExtentLogger.fail(markup_message, true);

	}

	public void onTestSkipped(ITestResult result) {

		count_skippedTCs = count_skippedTCs + 1;

		ExtentLogger.skip(ICON_BUG + "  " + "<b><i>" + result.getThrowable().toString() + "</i></b>");
		String logText = "<b>" + result.getMethod().getMethodName() + " is skipped.</b>" + "  " + ICON_SMILEY_FAIL;
		Markup markup_message = MarkupHelper.createLabel(logText, ExtentColor.YELLOW);
		ExtentLogger.skip(markup_message, true);

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		/*
		 * As of now, we are not using it
		 */
	}

	public void onStart(ITestContext result) {
		/*
		 * As of now, we are not using it.
		 * 
		 */
	}

	public void onFinish(ITestContext result) {
		/*
		 * As of now, we are not using it.
		 * 
		 */
	}

}
