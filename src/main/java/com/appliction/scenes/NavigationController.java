package com.appliction.scenes;

import com.appliction.model.Model;
import com.jfoenix.controls.JFXListCell;
import com.jfoenix.controls.JFXListView;
import com.sun.jmx.snmp.SnmpUnknownSubSystemException;
import io.datafx.controller.FXMLController;
import io.datafx.controller.context.FXMLViewContext;
import io.datafx.controller.flow.Flow;
import io.datafx.controller.flow.FlowException;
import io.datafx.controller.flow.FlowHandler;
import io.datafx.controller.flow.action.ActionTrigger;
import io.datafx.controller.flow.context.FXMLViewFlowContext;
import io.datafx.controller.flow.context.ViewFlowContext;
import io.datafx.controller.util.VetoException;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import java.util.Objects;

/**
 * Created by guru on 9/24/2017.
 */
@FXMLController(value="/fxml/Navigation.fxml" ,title = "Home")
public class NavigationController {

    @Inject
    Model model;

    @FXML
    @ActionTrigger("Home")
    Label Home;

    @FXML
    @ActionTrigger("Schedule")
    Label Schedule;

    @FXML
    @ActionTrigger("ScheduleList")
    Label ScheduleList;

    @FXML
    JFXListView<Label> navigation;

    @FXMLViewFlowContext
    private ViewFlowContext context;
    @PostConstruct
    public void init()

    {
        Objects.requireNonNull(context,"context");
        FlowHandler navigationhandler=(FlowHandler)context.getRegisteredObject("content");
        Flow flow = (Flow)context.getRegisteredObject("contentFlow");


        navigation.propagateMouseEventsToParent();
            navigation.getSelectionModel().selectedItemProperty().addListener((obs,oldvalue,newvalue) -> {
                if (newvalue != null)
                {
                    try {
                        System.out.println(": "+newvalue.getId());
                        navigationhandler.handle(newvalue.getId());
                    } catch (VetoException e) {
                        e.printStackTrace();
                    } catch (FlowException e) {
                        e.printStackTrace();
                    }
                }

            });


        flow.withGlobalLink(Home.getId(),OpeningController.class);
        flow.withGlobalLink(Schedule.getId(),ScheduleController.class);

        System.out.println("Navigation");
        System.out.println(model.getName());



    }
}
