package com.appliction.scenes;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXToggleNode;
import io.datafx.controller.FXMLController;
import io.datafx.controller.flow.context.FXMLViewFlowContext;
import io.datafx.controller.flow.context.ViewFlowContext;
import javafx.fxml.FXML;

import javax.annotation.PostConstruct;

/**
 * Created by guru on 9/27/2017.
 */
@FXMLController(value = "/fxml/schedule.fxml",title = "Home")
public class ScheduleController
{
    @FXMLViewFlowContext
    private ViewFlowContext context;

    @FXML
    private JFXButton schedule;

    @FXML
    private JFXToggleNode wifinode;


    @PostConstruct
    public void init()
    {
        System.out.println("Schedule");
    }
}
