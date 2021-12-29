package com.ui.utils;
/*This class have methods for screenshot*/
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class ScreenShotReport {
	static ExtentTest test;
	static ExtentReports report;
	File dest;
	static String ssfolderName;

	public static void logReport() {
		report = new ExtentReports(ssfolderName + "\\" + "ExtentReportResults.html", true);
		test = report.startTest("extentreportImplementaion");
	}

	public static String takeSreenshot(WebDriver driver) {
		String folderName = getFolderNameWithDate();
		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		ssfolderName = "wns_" + folderName;
		File dest = new File(
				"C:\\bin\\" + ssfolderName + "\\Screenshots\\" + "Screen_" + folderName + ".png");
		String filePath = dest.getAbsolutePath();
		try {
			FileUtils.copyFile(srcFile, dest);
		} catch (IOException e) {
			System.out.println("Folder not found :" + e);

		}
		return filePath;
	}

	public static void createDir() {
		String path = "C:\\bin\\" + getFolderNameWithDate();
		File dirLocal = new File(path);
		if (!dirLocal.exists()) {
			dirLocal.mkdir();

		}
	}

	public static String getFolderNameWithDate() {

		DateFormat dateFormat = new SimpleDateFormat("yyyy MM dd HH mm ss");
		Date date = new Date();
		String dtFromat = dateFormat.format(date);
		System.out.println(dateFormat.format(date));
		return dtFromat;
	}

}
