package utility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import org.testng.Reporter;

public class RetryLogic implements IRetryAnalyzer {
  int initialcount= 0;
  int retrycount = 2;
	@Override
	public boolean retry(ITestResult result) {
		// TODO Auto-generated method stub
		Reporter.log("Since the testcase got failed it has to be Retried 2 times");
		if(initialcount<retrycount)
		{
			initialcount++;
			return true;
		}
		return false;
	}

}
