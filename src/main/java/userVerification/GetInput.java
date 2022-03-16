package inputs;


  public abstract class GetInput {

	public abstract int getInput();

	public abstract God[] getvalue(String userMailId, String userPass);

//	public abstract int registerValitation() throws Exception;

	public abstract void registerValitation() throws Exception;

}
