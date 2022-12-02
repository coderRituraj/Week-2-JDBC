package com.bhavna.tester;

import com.bhavna.dao.Datadao;
import com.bhavna.service.Operations;

public class Main {

	public static void main(String[] args) {
		Datadao dataObj=new Datadao();
		//dataObj.takeEmpData();
		//dataObj.takeDepData();
		//dataObj.updateEData();
		Operations.fetchData();
		//Operations.countEmployeesAbove30K();


	}

}
