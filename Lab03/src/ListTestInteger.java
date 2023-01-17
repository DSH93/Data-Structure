public class ListTestInteger extends ListTest<Integer> {
	private static int j = 0;
	@Override
	public Integer getParameterInstance() {
		return j++;
	}

}