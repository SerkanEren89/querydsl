package com.serkaneren.querydsl.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TodoDto implements Serializable {

    private UUID uuid;

    private String note;

    private String title;

    private boolean active;

    private Date startDate;

    private Date endDate;
}
