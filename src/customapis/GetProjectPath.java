package customapis;

import java.util.logging.Logger;

import com.provar.core.model.base.api.ValueScope;
import com.provar.core.testapi.ITestExecutionContext;
import com.provar.core.testapi.annotations.*;

@TestApi(title = "Get Project Path", summary = "", remarks = "", iconBase = "", defaultApiGroups = { "Custom" })
@TestApiParameterGroups(parameterGroups = { @TestApiParameterGroup(groupName = "inputs", title = "Inputs"),
		@TestApiParameterGroup(groupName = "result", title = "Result"), })
public class GetProjectPath {

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

		// Put our implementation logic here.
		String projectPath = testExecutionContext.getProjectPath();

		testLogger.info("Project path is --" + projectPath);

		// Store the result (if appropriate).
		testExecutionContext.setValue(resultName, projectPath, resultScope);

	}

}
