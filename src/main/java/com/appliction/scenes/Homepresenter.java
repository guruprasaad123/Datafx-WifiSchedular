package com.appliction.scenes;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import com.appliction.model.ExtendedAnimatedFlowContainer;
import com.appliction.model.Model;
import com.jfoenix.controls.JFXButton;

import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXDrawersStack;
import com.jfoenix.controls.JFXHamburger;
import io.datafx.controller.FXMLController;
import io.datafx.controller.flow.Flow;
import io.datafx.controller.flow.FlowException;
import io.datafx.controller.flow.FlowHandler;
import io.datafx.controller.flow.context.FXMLViewFlowContext;
import io.datafx.controller.flow.context.ViewFlowContext;
import javafx.animation.Transition;
import javafx.fxml.FXML;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;
import static io.datafx.controller.flow.container.ContainerAnimations.SWIPE_LEFT;

@FXMLController(value="/fxml/Home.fxml",title="Home")
public class Homepresenter {
	@FXML
	JFXHamburger titleBurger;
    @FXML
    private StackPane titleBurgerContainer;
	@FXML
	JFXDrawer drawer;
    @FXMLViewFlowContext
    private ViewFlowContext context;
    @Inject
    private Model model;

@PostConstruct()
public void init()
{
    try {
	System.out.println("Init");
	System.out.println(model.getName());
	model.setName("model1");

   drawer.setOnDrawerOpening(e -> {
       final Transition animation = titleBurger.getAnimation();
       animation.setRate(1);
       animation.play();
   });

    drawer.setOnDrawerClosing(e -> {
        final Transition animation = titleBurger.getAnimation();
        animation.setRate(-1);
        animation.play();
    });

    titleBurgerContainer.setOnMouseClicked(e -> {
        if (drawer.isHidden() || drawer.isHiding()) {
            drawer.open();
        } else {
            drawer.close();
        }
    });

    context= new ViewFlowContext();

    Flow opening = new Flow(OpeningController.class);

    FlowHandler openingHandler=opening.createHandler(context);
    Flow navigation = new Flow(NavigationController.class);
    FlowHandler navigationHandler=navigation.createHandler(context);


    context.register("content",openingHandler);
    context.register("contentFlow",opening);
        final Duration containerAnimationDuration = Duration.millis(320);

    drawer.setContent(openingHandler.start(new ExtendedAnimatedFlowContainer(containerAnimationDuration,SWIPE_LEFT)));

  //  drawer.setContent(opening.start(new ExtendedAnimatedFlowContainer(containerAnimationDuration,SWIPE_LEFT)));
    drawer.setSidePane(navigationHandler.start());

    }
    catch (FlowException e) {
        e.printStackTrace();
    }
}
}