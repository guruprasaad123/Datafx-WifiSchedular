package com.appliction;/**
 * Created by guru on 9/23/2017.
 */

import com.appliction.scenes.Homepresenter;
import com.jfoenix.controls.JFXDecorator;
import com.gluonhq.charm.down.Platform;
import io.datafx.controller.context.FXMLViewContext;
import io.datafx.controller.flow.Flow;
import io.datafx.controller.flow.FlowException;
import io.datafx.controller.flow.container.DefaultFlowContainer;
import io.datafx.controller.flow.context.ViewFlowContext;

import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;

import javax.inject.Inject;


public class Main extends Application
{

    public static void main(String[] args) {
        launch(args);
    }

    @FXMLViewContext
    private ViewFlowContext content;

    @Override
    public void start(Stage stage) {
      try {
          Rectangle2D visual = Screen.getPrimary().getVisualBounds();
          Flow flow = new Flow(Homepresenter.class);
          DefaultFlowContainer container = new DefaultFlowContainer();
          content = new ViewFlowContext();
          flow.createHandler(content).start(container);

          JFXDecorator decorator = new JFXDecorator(stage, container.getView());
          decorator.setCustomMaximize(false);
          Scene scene=null;
          if(Platform.isAndroid())
          {
              scene=new Scene(decorator,visual.getWidth(),visual.getHeight());
          }
           scene = new Scene(decorator);
          scene.getStylesheets().add("/css/main.css");
          stage.setScene(scene);
          stage.show();
      }
       catch (FlowException e)
       {
          e.printStackTrace();
      }
    }
    }

