package FullProject.TestClass;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer {
    private static final int MAX_RETRY_COUNT = 2; // Set the maximum number of retries

    private int retryCount = 0;

    @Override
    public boolean retry(ITestResult result) {
        if (retryCount < MAX_RETRY_COUNT) {
            retryCount++;
            return true; // Retry the test
        }
        return false; // Do not retry the test
    }
}






