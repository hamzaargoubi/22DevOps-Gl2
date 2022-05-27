package com.esprit.examen;

import com.esprit.examen.entities.Planning;
import com.esprit.examen.services.IPlanningService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestServicePlanning {
    @Autowired
    public IPlanningService planningService;


    @Test
    public void addPlanning(){
        Planning planning = new Planning(2018,"3CInfoGL-2");
        assertThat(planning.getYear()).isNotZero();
        planningService.addPlanning(planning);
    }

    @Test
    public void testListPlannings() {
        List<Planning> plannings =  planningService.listPlanning();
        assertThat(plannings).size().isPositive();
    }
}
