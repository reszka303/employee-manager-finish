package com.github.employeemanager.components.resource;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.employeemanager.components.domain.Employee;
import com.github.employeemanager.components.dto.request.EmployeeRequestDto;
import com.github.employeemanager.components.dto.response.EmployeeResponseDto;
import com.github.employeemanager.components.service.EmployeeServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
class EmployeeResourceMvcTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EmployeeServiceImpl service;

    @Autowired
    private ObjectMapper mapper;

    private EmployeeRequestDto request;

    private EmployeeResponseDto response;

    @Test
    public void shouldReturnAllEmployeesWhenThereIsNoRequestParameter() throws Exception {

        //given
        List<EmployeeResponseDto> employees = getListEmployeeResponseDto();
        given(service.getAllEmployees()).willReturn(employees);

        //when
        ResultActions result = mockMvc.perform(get("/api/employees", employees)
                .contentType(APPLICATION_JSON));

        //then
        result.andExpect(status().isOk())
                .andDo(print())
                .andExpect(jsonPath("$.size()", is(employees.size())));
    }

    @Test
    public void shouldReturnEmployeesListWhenRequestParameterIs() throws Exception {

        //given
        String samwe = "samwe";
        List<EmployeeResponseDto> employees = getListEmployeeWithNameParameter();
        given(service.getEmployeeByName(samwe)).willReturn(employees);

        //when
        ResultActions result = mockMvc.perform(get("/api/employees?name=samwe")
                .contentType(APPLICATION_JSON));

        //then
        result.andExpect(status().isOk())
                .andDo(print())
                .andExpect(jsonPath("$.size()", is(employees.size())));
    }

    private List<EmployeeResponseDto> getListEmployeeWithNameParameter() {

        EmployeeResponseDto lucasSamweyes =
                new EmployeeResponseDto(
                        1L,
                        "Lucas Samweyes",
                        "lsamweyes0@fda.com",
                        "Senior Full-Stack Developer",
                        "300-245-4509",
                        "https://www.bootdey.com/app/webroot/img/Content/avatar/avatar7.png",
                        "2f0d3f6a-136c-49f5-8d4b-16ede1578873"
                );

        EmployeeResponseDto olivierSamweyes =
                new EmployeeResponseDto(
                        6L,
                        "Olivier Samweyes",
                        "lsamweyes0@fda.com",
                        "Senior Full-Stack Developer",
                        "300-245-4509",
                        "https://www.bootdey.com/app/webroot/img/Content/avatar/avatar7.png",
                        "2f0d3f6a-136c-49f5-8d4b-16ede1578873"

                );

        List<EmployeeResponseDto> list = new ArrayList<>();

        list.add(lucasSamweyes);
        list.add(olivierSamweyes);

        return list;
    }

    private List<EmployeeResponseDto> getListEmployeeResponseDto() {

        EmployeeResponseDto lucasSamweyes =
                new EmployeeResponseDto(
                        1L,
                        "Lucas Samweyes",
                        "lsamweyes0@fda.com",
                        "Senior Full-Stack Developer",
                        "300-245-4509",
                        "https://www.bootdey.com/app/webroot/img/Content/avatar/avatar7.png",
                        "2f0d3f6a-136c-49f5-8d4b-16ede1578873"
                );

        EmployeeResponseDto oliverSkerratt =
                new EmployeeResponseDto(
                        2L,
                        "Oliver Skerratt",
                        "oskerratt@fda.com",
                        "Senior Java Developer",
                        "363-977-1893",
                        "https://www.bootdey.com/app/webroot/img/Content/avatar/avatar5.png",
                        "a346cce8-c33f-427b-884d-8a4d113bd164"
                );

        EmployeeResponseDto jamesCowderoy =
                new EmployeeResponseDto(
                        3L,
                        "James Cowderoy",
                        "jcowderoy@fda.com",
                        "Chief Executive Officer",
                        "955-985-2702",
                        "https://www.bootdey.com/img/Content/avatar/avatar1.png",
                        "bec4f978-7c05-45a4-b1c4-6bc8e457ad17"
                );

        EmployeeResponseDto barrieRockcliffe =
                new EmployeeResponseDto(
                        4L,
                        "Barrie Rockcliffe",
                        "brockcliffe@fda.com",
                        "Senior Front-End Developer",
                        "490-351-2899",
                        "https://www.bootdey.com/app/webroot/img/Content/avatar/avatar6.png",
                        "22dea798-e979-4393-afd4-f76765893c4e"
                );

        EmployeeResponseDto krystleFeasley =
                new EmployeeResponseDto(
                        5L,
                        "Krystle Feasley",
                        "kfeasley@fda.com",
                        "Secretary",
                        "473-436-5477",
                        "https://www.bootdey.com/app/webroot/img/Content/avatar/avatar3.png",
                        "0f82f41d-aff7-40a8-8842-0b5c46f57763"
                );

        EmployeeResponseDto olivierSamweyes =
                new EmployeeResponseDto(
                        6L,
                        "Olivier Samweyes",
                        "lsamweyes0@fda.com",
                        "Senior Full-Stack Developer",
                        "300-245-4509",
                        "https://www.bootdey.com/app/webroot/img/Content/avatar/avatar7.png",
                        "2f0d3f6a-136c-49f5-8d4b-16ede1578873"

                );

        List<EmployeeResponseDto> list = new ArrayList<>();

        list.add(lucasSamweyes);
        list.add(oliverSkerratt);
        list.add(jamesCowderoy);
        list.add(barrieRockcliffe);
        list.add(krystleFeasley);
        list.add(olivierSamweyes);

        return list;
    }

}