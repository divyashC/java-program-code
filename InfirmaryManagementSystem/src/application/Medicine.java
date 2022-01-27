package application;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Medicine {

	private DoubleProperty medicineQuantity;
	private StringProperty medicineName, medicineExpiryDate;

	//Constructor
	public Medicine() {

		this.medicineName = new SimpleStringProperty();
		this.medicineQuantity = new SimpleDoubleProperty();
		this.medicineExpiryDate = new SimpleStringProperty();

	}

	//Getters and Setters for Table View
	public String getMedicineName() {
		return medicineName.get();
	}

	public void setMedicineName(String medicineName) {
		this.medicineName.set(medicineName);
	}

	public StringProperty get_MedicineName() {
		return medicineName;
	}

	public Double getMedicineQuantity() {
		return medicineQuantity.get();
	}

	public void setMedicineQuantity(Double medicineQuantity) {
		this.medicineQuantity.set(medicineQuantity);
	}

	public DoubleProperty get_MedicineQuantity() {
		return medicineQuantity;
	}

	public String getMedicineExpiryDate() {
		return medicineExpiryDate.get();
	}

	public void setMedicineExpiryDate(String medicineExpiryDate) {
		this.medicineExpiryDate.set(medicineExpiryDate);
	}

	public StringProperty get_MedicineExpiryDate() {
		return medicineExpiryDate;
	}

}
