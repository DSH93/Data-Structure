public class MatrixTestObject extends MatrixTest<Object> {
	int i = 0;
	public Integer getParameterInstance() {
		return i++;
	}

}
