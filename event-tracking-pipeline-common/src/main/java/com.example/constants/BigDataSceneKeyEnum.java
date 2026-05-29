package com.example.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;

@Getter
@AllArgsConstructor
public enum BigDataSceneKeyEnum implements Serializable {

    APP_EXAMPLE_SCENE("100000", "example"),
    SHIPPING_LOG("900902", "SHIPPING"),

    ;

    private String sceneKey;

    private String sceneDesc;

}
