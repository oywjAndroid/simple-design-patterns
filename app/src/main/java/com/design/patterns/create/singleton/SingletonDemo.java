package com.design.patterns.create.singleton;

import com.design.patterns.base.TestUnit;

public class SingletonDemo extends TestUnit {

    @Override
    public void main() {
        Company company = new Company();

        CEO ceo1 = CEO.getInstance();
        CEO ceo2 = CEO.getInstance();
        company.addPerson(ceo1);
        company.addPerson(ceo2);

        Vp vp1 = new Vp();
        Vp vp2 = new Vp();
        Vp vp3 = new Vp();
        company.addPerson(vp1);
        company.addPerson(vp2);
        company.addPerson(vp3);

        Staff staff1 = new Staff();
        Staff staff2 = new Staff();
        Staff staff3 = new Staff();
        Staff staff4 = new Staff();
        Staff staff5 = new Staff();
        company.addPerson(staff1);
        company.addPerson(staff2);
        company.addPerson(staff3);
        company.addPerson(staff4);
        company.addPerson(staff5);

        company.meeting();
    }
}
