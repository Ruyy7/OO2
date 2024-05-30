package ar.edu.unlp.oo2.persitencia;

public class UserRepositoryProxy {
	private UserRepository userRepo;
	private boolean required;

	public UserRepositoryProxy(UserRepository userRepo) {
		this.userRepo = userRepo;
		this.required = false;
	}
	
	public void requestDeploy() {
		this.required = true;
	}
	
	public boolean isRequiered() {
		return this.required;
	}
	
	public PersistableUser findUserByUsername(String aUsername) {
		if (this.required) {
			return this.userRepo.findUserByUsername(aUsername);
		}
		throw new RuntimeException("Not allowed");
	}
}
