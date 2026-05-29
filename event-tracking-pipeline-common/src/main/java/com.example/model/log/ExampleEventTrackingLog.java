package com.example.model.log;

import lombok.Getter;
import lombok.Setter;

import com.example.constants.EventTrackingSceneKeyEnum;

@Getter
@Setter
public class ExampleEventTrackingLog extends BaseEventTrackingLog {

    public ExampleEventTrackingLog() {
        super(EventTrackingSceneKeyEnum.APP_EXAMPLE_SCENE);
    }
}
