package com.testing.logging;

import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import java.util.Map;

public class CustomListener extends TestListenerAdapter {

    private final static String FAILED = "Failed";
    private final static String SKIPPED = "Skipped";
    private final static String SUCCESS = "Success";

    @Override
    public void onTestStart(ITestResult tr) {
        String info = tr.getTestClass().getRealClass().getSimpleName()
                + "|Executing " + tr.getName();

        Map params = tr.getMethod().findMethodParameters(tr.getMethod().getXmlTest());
        if (!params.isEmpty()) {
            info += "|" + params;
        }

        Log.Debug(info);
    }

    @Override
    public void onTestFailure(ITestResult tr) {
        log (FAILED, tr);
    }
	 
    @Override
    public void onTestSkipped(ITestResult tr) {
        log (SKIPPED, tr);
    }
	 
    @Override
    public void onTestSuccess(ITestResult tr) {
        log (SUCCESS, tr);
    }

    private void log (String status, ITestResult tr) {
        String log = tr.getTestClass().getRealClass().getSimpleName() + "|Test " + tr.getName()
                + " is " + status + " in " + (tr.getEndMillis() - tr.getStartMillis()) + " ms"
                + "|Thread " + Thread.currentThread().getId();
        Log.Debug(log);
    }

}