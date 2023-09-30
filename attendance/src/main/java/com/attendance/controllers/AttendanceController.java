package com.attendance.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.attendance.dtos.AttendanceDto;
import com.attendance.models.Attendance;
import com.attendance.services.AttendanceServices;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/attendance")
@RequiredArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AttendanceController {
  
  private final AttendanceServices _attendanceServices;


  @PostMapping("/save")
  public String save(@RequestBody AttendanceDto attendanceDto) {
      return _attendanceServices.save(attendanceDto);
  }

  @GetMapping
  public List<Attendance> getAllEmployees(){
    return _attendanceServices.findAll();
  }




}
