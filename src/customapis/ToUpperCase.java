package customapis;

import java.util.logging.Logger;

import com.provar.core.model.base.api.ValueScope;
import com.provar.core.testapi.ITestExecutionContext;
import com.provar.core.testapi.annotations.*;

@TestApi(title = "To Upper Case", summary = "", remarks = "", iconBase = "", defaultApiGroups = { "Custom" })
@TestApiParameterGroups(parameterGroups = { @TestApiParameterGroup(groupName = "inputs", title = "Inputs"),
		@TestApiParameterGroup(groupName = "result", title = "Result"), })
public class ToUpperCase {

	@TestApiParameter(seq = 1, summary = "The first parameter's summary.", remarks = "", mandatory = true, parameterGroup = "inputs")
	public String inputString;

	@TestApiParameter(seq = 10, summary = "The name that the result will be stored under.", remarks = "", mandatory = true, parameterGroup = "result")
	public String resultName;

	@TestApiParameter(seq = 11, summary = "The lifespan of the result.", remarks = "", mandatory = true, parameterGroup = "result", defaultValue = "Test")
	public ValueScope resultScope;

	@TestLogger
	public Logger testLogger;

	@TestExecutionContext
	public ITestExecutionContext testExecutionContext;

	@TestApiExecutor
	public void execute() {

		String result = "";

		testLogger.info("--Converting " + inputString + " to upper case--");

		result = inputString.toUpperCase();

		testExecutionContext.setValue(resultName, result, resultScope);
	}
}
