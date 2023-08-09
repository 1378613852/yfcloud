package com.yfcloud.springcloud.entitles;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
public class Payment implements Serializable {
    private Long id;
    private String serial;
}
