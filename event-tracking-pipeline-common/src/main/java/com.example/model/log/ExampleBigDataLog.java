package com.example.model.log;

import lombok.Getter;
import lombok.Setter;

import com.example.constants.BigDataSceneKeyEnum;

@Getter
@Setter
public class ExampleBigDataLog extends AbstractBigDataLog {

    public ExampleBigDataLog() {
        super(BigDataSceneKeyEnum.APP_EXAMPLE_SCENE);
    }


}
