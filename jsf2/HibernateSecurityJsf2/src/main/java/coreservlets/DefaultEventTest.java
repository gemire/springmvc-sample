package coreservlets;

import java.util.*;
import javax.faces.component.behavior.ClientBehaviorHolder;
import javax.faces.component.html.*;

public class DefaultEventTest {
  public static void main(String[] args) {
    ClientBehaviorHolder[] components =
      {  new HtmlCommandButton(), new HtmlCommandLink(), new HtmlDataTable(), new HtmlForm(), new HtmlGraphicImage(), 
         new HtmlInputSecret(), new HtmlInputText(), new HtmlInputTextarea(), new HtmlOutcomeTargetButton(), 
         new HtmlOutcomeTargetLink(), new HtmlOutputLabel(), new HtmlOutputLink(), new HtmlPanelGrid(), 
         new HtmlSelectBooleanCheckbox(), new HtmlSelectManyCheckbox(), new HtmlSelectManyListbox(), 
         new HtmlSelectManyMenu(), new HtmlSelectOneListbox(), new HtmlSelectOneMenu(), new HtmlSelectOneRadio()
      };
    for(ClientBehaviorHolder component: components) {
      showEvents(component);
    }
  }
  
  public static void showEvents(ClientBehaviorHolder component) {
    System.out.printf("%s:%n", component.getClass().getSimpleName());
    System.out.printf("  Default event: %s%n", component.getDefaultEventName());
    System.out.printf("  All events:    ");
    Collection<String> eventNames = component.getEventNames();
    for(String eventName: eventNames) {
      System.out.printf("%s ", eventName);
    }
    System.out.println();
  }
}
