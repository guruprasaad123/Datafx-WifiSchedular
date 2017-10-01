package com.appliction.scenes;

import com.jfoenix.controls.JFXButton;
import io.datafx.controller.FXMLController;
import io.datafx.controller.context.FXMLViewContext;
import io.datafx.controller.flow.action.ActionMethod;
import io.datafx.controller.flow.action.ActionTrigger;
import io.datafx.controller.flow.action.LinkAction;
import io.datafx.controller.flow.context.ViewFlowContext;
import javafx.fxml.FXML;

import javax.annotation.PostConstruct;
import java.util.Objects;

/**
 * Created by guru on 9/25/2017.
 */
@FXMLController(value = "/fxml/opening.fxml",title = "Home")
public class OpeningController {

    @FXML
    private JFXButton Schedule;

    @FXMLViewContext
    ViewFlowContext content;


    @PostConstruct
    public  void init()
    {
        //Objects.requireNonNull(content,"contents");
    System.out.println("opening");

    }


}
