package model;

public class HealthCheckLogic {
	public void Excute(Health health) {//クラスが引数配列が引数参照なのでreturnがない本体そのもの変えているbmi とbodyTypeはnull
		double weight = health.getWeight();
		double height = health.getHeight() / 100.0;
		double bmi = weight / (height * height);
		health.setBmi(bmi);
		
		String bodyType;
		if(bmi < 18.5) {
			bodyType = "やせ型";
		} else if(bmi < 25) {
			bodyType = "普通";
		} else {
			bodyType = "肥満";			
		}
		health.setBodyType(bodyType);
		
	}
}
