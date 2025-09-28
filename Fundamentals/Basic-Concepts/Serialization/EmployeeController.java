package BasicJava.Serialization;

class EmployeeController {
	  private EmployeeModel model;
	  private EmployeeView view;

	  public EmployeeController(EmployeeModel model, EmployeeView view) {
	    this.model = model;
	    this.view = view;
	  }

	  public void setEmployeeName(String name) {
	    model.setName(name);
	  }

	  public String getEmployeeName() {
	    return model.getName();
	  }

	  public void setEmployeeId(String rollNo) {
	    model.setId(rollNo);
	  }

	  public String getEmployeeId() {
	    return model.getId();
	  }

	  public void updateView() {
	    view.printEmployeeDetails(model.getName(), model.getId());
	  }
	  public void showDetails(){
		  view.showDetails(model.getName(), model.getId());
	  }
	}