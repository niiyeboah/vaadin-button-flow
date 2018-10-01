/*
 * Copyright 2000-2017 Vaadin Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.vaadin.flow.component.button.demo;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H4;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.demo.DemoView;
import com.vaadin.flow.router.Route;

/**
 * View for {@link Button} demo.
 */
@Route("vaadin-button")
public class ButtonView extends DemoView {
    private Div message;

    @Override
    public void initView() {
        // Basics
        createBasicButton();
        createDisabled();
        createUsingAnIcon();
        // Accessibility
        createAccessibleIconButton();
        createAccessibleButton();
        // Theme Variants
        createTypes();
        createColors();
        createSizes();
        createIconButtons();

        message = new Div();
        message.setId("buttonMessage");
        add(message);
    }

    // begin-example-category
    // example-category-name: Basics
    private void createBasicButton() {
        // begin-source-example
        // source-example-heading: Basic Button
        Button button = new Button("Button");
        button.addClickListener(this::showButtonClickedMessage);
        // end-source-example

        addCard("Default button", button);
        button.setId("default-button");
    }

    private void createDisabled() {
        // begin-source-example
        // source-example-heading: Disabled
        Button button = new Button("Disabled");
        button.setEnabled(false);
        // end-source-example

        addCard("Disabled button", button);
        button.addClickListener(evt -> message.setText("Button " + evt.getSource().getText()
                + " was clicked, but the button is disabled and this shouldn't happen!"));
        button.setId("disabled-button");
    }

    private void createUsingAnIcon() {
        // begin-source-example
        // source-example-heading: Using an Icon
        Button EditButton = new Button("Edit", new Icon(VaadinIcon.EDIT));

        Button rightButton = new Button("Next", new Icon(VaadinIcon.ARROW_RIGHT));
        rightButton.setIconAfterText(true);
        // end-source-example

        EditButton.addClickListener(this::showButtonClickedMessage);
        rightButton.addClickListener(this::showButtonClickedMessage);

        addCard("Buttons with icons", EditButton, rightButton);
        EditButton.setId("left-icon-button");
        rightButton.setId("right-icon-button");
    }
    // end-example-category

    // begin-example-category
    // example-category-name: Accessibility
    private void createAccessibleButton() {
        // begin-source-example
        // source-example-heading: Accessible Button
        Button button = new Button("OK");
        // end-source-example

        addCard("Accessible button", button);
        button.setId("accessible-button");
    }

    private void createAccessibleIconButton() {
        // begin-source-example
        // source-example-heading: Accessible Icon Button
        Button button = new Button(new Icon(VaadinIcon.PLUS));
        button.getElement().setAttribute("aria-label", "Create New");
        // end-source-example

        addCard("Accessible Icon Button", button);
        button.setId("accessible-icon-button");
    }
    // end-example-category

    // begin-example-category
    // example-category-name: Theme Variants
    private void createTypes() {
        // begin-source-example
        // source-example-heading: Types
        Button primaryButton = new Button("Primary");
        primaryButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);

        Button secondaryButton = new Button("Secondary");

        Button tertiaryButton = new Button("Tertiary");
        tertiaryButton.addThemeVariants(ButtonVariant.LUMO_TERTIARY);

        Button tertiaryInlineButton = new Button("Tertiary Inline");
        tertiaryInlineButton.addThemeVariants(ButtonVariant.LUMO_TERTIARY, ButtonVariant.LUMO_TERTIARY_INLINE);
        // end-source-example

        addCard("Accessible Icon Button", primaryButton, secondaryButton, tertiaryButton, tertiaryInlineButton);
        primaryButton.setId("primary-button");
        secondaryButton.setId("secondary-button");
        tertiaryButton.setId("tertiary-button");
        tertiaryInlineButton.setId("tertiary-inline-button");
    }

    private void createColors() {
        // begin-source-example
        // source-example-heading: Colors
        H4 contrastHeader = new H4("Contrast");

        Button primaryContrastButton = new Button("Primary");
        primaryContrastButton.addThemeVariants(ButtonVariant.LUMO_CONTRAST, ButtonVariant.LUMO_PRIMARY);

        Button secondaryContrastButton = new Button("Secondary");

        Button tertiaryContrastButton = new Button();
        tertiaryContrastButton.addThemeVariants(ButtonVariant.LUMO_CONTRAST, ButtonVariant.LUMO_TERTIARY);

        H4 successHeader = new H4("Success");

        Button primarySuccessButton = new Button("Primary");
        primarySuccessButton.addThemeVariants(ButtonVariant.LUMO_SUCCESS, ButtonVariant.LUMO_PRIMARY);

        Button secondarySuccessButton = new Button("Secondary");

        Button tertiarySuccessButton = new Button();
        tertiarySuccessButton.addThemeVariants(ButtonVariant.LUMO_SUCCESS, ButtonVariant.LUMO_TERTIARY);

        H4 errorHeader = new H4("Error");

        Button primaryErrorButton = new Button("Primary");
        primaryErrorButton.addThemeVariants(ButtonVariant.LUMO_ERROR, ButtonVariant.LUMO_PRIMARY);

        Button secondaryErrorButton = new Button("Secondary");

        Button tertiaryErrorButton = new Button();
        tertiaryErrorButton.addThemeVariants(ButtonVariant.LUMO_ERROR, ButtonVariant.LUMO_TERTIARY);
        // end-source-example

        addCard("Colors", contrastHeader, primaryContrastButton, secondaryContrastButton, tertiaryContrastButton,
                successHeader, primarySuccessButton, secondarySuccessButton, tertiarySuccessButton, primaryErrorButton,
                errorHeader, primaryErrorButton, secondaryErrorButton, tertiaryErrorButton);
        contrastHeader.setId("contrast-header");
        primaryContrastButton.setId("primary-contrast-button");
        secondaryContrastButton.setId("secondary-contrast-button");
        tertiaryContrastButton.setId("tertiary-contrast-button");

        successHeader.setId("success-header");
        primarySuccessButton.setId("primary-success-button");
        secondarySuccessButton.setId("secondary-success-button");
        tertiarySuccessButton.setId("tertiary-success-button");

        errorHeader.setId("error-header");
        primaryErrorButton.setId("primary-error-button");
        secondaryErrorButton.setId("secondary-error-button");
        tertiaryErrorButton.setId("tertiary-error-button");
    }

    private void createSizes() {
        // begin-source-example
        // source-example-heading: Sizes
        Button largeButton = new Button("Large");
        largeButton.addThemeVariants(ButtonVariant.LUMO_LARGE);

        Button normalButton = new Button("Normal");

        Button smallButton = new Button("Primary");
        smallButton.addThemeVariants(ButtonVariant.LUMO_SMALL);
        // end-source-example

        addCard("Sizes", largeButton, normalButton, smallButton);
        largeButton.setId("large-button");
        normalButton.setId("normal-button");
        smallButton.setId("small-button");
    }

    private void createIconButtons() {
        // begin-source-example
        // source-example-heading: Icon Buttons
        Button plusButton = new Button(new Icon(VaadinIcon.PLUS));
        plusButton.addThemeVariants(ButtonVariant.LUMO_ICON);

        Button crossButton = new Button(new Icon(VaadinIcon.CLOSE_SMALL));
        crossButton.addThemeVariants(ButtonVariant.LUMO_ICON);
        // end-source-example

        addCard("Icon Buttons", plusButton, crossButton);
        plusButton.setId("plus-button");
        crossButton.setId("cross-button");
    }
    // end-example-category

    private void showButtonClickedMessage(ClickEvent<Button> evt) {
        Button source = evt.getSource();
        source.getParent().ifPresent(parent -> parent.getElement().insertChild(parent.getElement().getChildCount() - 2,
                message.getElement()));

        String text = source.getText();
        if (text.isEmpty() && containsChild(source, "img")) {
            text = "with image";
        } else if (text.isEmpty() && containsChild(source, "iron-icon")) {
            text = "thumbs up";
        }

        message.setText("Button " + text + " was clicked.");
    }

    private boolean containsChild(Component parent, String tagName) {
        return parent.getElement().getChildren().anyMatch(element -> element.getTag().equals(tagName));
    }
}
