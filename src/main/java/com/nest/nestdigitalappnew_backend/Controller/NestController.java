package com.nest.nestdigitalappnew_backend.Controller;

import com.nest.nestdigitalappnew_backend.dao.*;
import com.nest.nestdigitalappnew_backend.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Date;

@RestController
public class NestController {
    @Autowired
    private EmployeeDao dao;
    @Autowired
    private LeaveDao ldao;
    @Autowired
    private SecurityDao sdao;
    @Autowired
    private LeaveApplicationDao ladao;
    @Autowired
    private VisitorLogEntryDao vdao;
    @Autowired
    private EmployeeLoginEntryDao eldao;

    @CrossOrigin(value ="*")
    @PostMapping(path="/addemp",consumes = "application/json",produces = "application/json")
    public HashMap<String,String>addEmployee(@RequestBody Employees e)
    {

        System.out.println(e.getEmpcode());
        HashMap<String,String>map=new HashMap<>();
        map.put("status","success");
        dao.save(e);

        return map;

    }
    @CrossOrigin(value="*")
    @PostMapping(path="/leave",consumes = "application/json",produces = "application/json")
    public HashMap<String,String>leaveCount(@RequestBody LeaveClass l)
    {
        System.out.println(l.getEmpid());
        HashMap<String,String>map=new HashMap<>();
        map.put("status","success");
        ldao.save(l);
        return map;

    }
    @CrossOrigin(value="*")
    @PostMapping(path="/searchemp",consumes = "application/json",produces = "application/json")
    public List<Employees> searchEmployee(@RequestBody Employees e)
    {
        System.out.println(e.getEmpcode());

        return (List<Employees>) dao.searchEmployee(e.getEmpcode());
    }
    @CrossOrigin(value="*")
    @PostMapping(path="/deleteemp",consumes = "application/json",produces = "application/json")
    public HashMap<String,String> deleteEmployee(@RequestBody Employees e)
    {
        System.out.println(e.getId());
        HashMap<String,String>map=new HashMap<>();
        map.put("status","success");
        dao.deleteEmployee(e.getId());
        return map;

    }
    @CrossOrigin(value="*")
    @PostMapping(path="/updateemp",consumes = "application/json",produces = "application/json")
    public HashMap<String,String>updateEmployee(@RequestBody Employees e)
    {
        HashMap<String,String>map=new HashMap<>();
        map.put("status","success");
        dao.updateEmployee(e.getId(),e.getAddress(),e.getEmail(),e.getEmpname(),e.getMobno(),e.getUsername());
        return map;

    }
    @CrossOrigin(value="*")
    @PostMapping(path="/addsecurity",consumes = "application/json",produces = "application/json")
    public HashMap<String,String>addSecurity(@RequestBody Security e)
    {

        System.out.println(e.getSname());
        HashMap<String,String>map=new HashMap<>();
        map.put("status","success");
        sdao.save(e);
        return map;

    }
    @CrossOrigin(value="*")
    @PostMapping(path="/searchsecurity",consumes = "application/json",produces = "application/json")
    public List<Security> searchSecurity(@RequestBody Security e)
    {
        System.out.println(e.getSecuritycode());

        return (List<Security>)sdao.addSecurity(e.getSecuritycode());
    }
    @CrossOrigin(value="*")
    @PostMapping(path="/deletesecurity",consumes = "application/json",produces = "application/json")
    public HashMap<String,String> deleteSecurity(@RequestBody Security e)
    {

        HashMap<String,String>map=new HashMap<>();
        map.put("status","success");
        sdao.deleteSecurity(e.getId());
        return map;
    }
    @CrossOrigin(value="*")
    @PostMapping(path="/updatesecurity",consumes = "application/json",produces = "application/json")
    public HashMap<String,String>updateSecurity(@RequestBody Security e)
    {
        HashMap<String,String>map=new HashMap<>();
        map.put("status","success");
        sdao.updateSecurity(e.getId(),e.getAddress(),e.getMobileno(),e.getSname(),e.getUsername());
        return map;

    }
    @CrossOrigin(origins = "*")
    @PostMapping(path="/leavapplication",consumes = "application/json", produces ="application/json")
    public HashMap<String, String> securityUpdate(@RequestBody LeaveApplication la)
    {
        SimpleDateFormat obj = new SimpleDateFormat("MM-dd-yyyy");
        try
        {
            Date date1 = obj.parse(la.getStart_date());
            Date date2 = obj.parse(la.getEnd_date());
            long time_difference = date2.getTime() - date1.getTime();
            long days_difference = (time_difference / (1000*60*60*24)) % 365;
            la.setNo_of_days(days_difference);
        }
        catch (ParseException excep) {
            excep.printStackTrace();
        }
        System.out.println(la.getNo_of_days());
        HashMap<String,String> map = new HashMap<>();
        ladao.save(la);
        map.put("status","success");
        return map;
    }
    @CrossOrigin(origins = "*")
    @PostMapping(path="/visitorlogentry",consumes = "application/json",produces = "application/json")
    public HashMap<String,String>VisitorLogEntry(@RequestBody VisitorLogEntry v)
    {
        System.out.println(v.getName());
        vdao.save(v);
        HashMap<String,String>map = new HashMap<>();
        map.put("status","success");
        return map;
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path="/employeelogentry",consumes = "application/json",produces = "application/json")
    public HashMap<String,String>employeeLogEntry(@RequestBody EmployeeLoginEntry ele)
    {
        System.out.println(ele.getEmpcode());
        eldao.save(ele);
        HashMap<String,String>map = new HashMap<>();
        map.put("status","success");
        return map;
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path="/employeeviewstatus",consumes = "application/json",produces = "application/json")
    public List<LeaveApplication>employeeViewStatus(@RequestBody LeaveApplication la)
    {
        System.out.println(la.getEmpid());
        return(List<LeaveApplication>)ladao.employeeViewStatus(la.getEmpid());
    }
    @CrossOrigin(origins="*")
    @PostMapping(path="/employeeauth",consumes = "application/json",produces = "application/json")
    public HashMap<String,String>employeeAuth(@RequestBody Employees e)
    {
        List<Employees>result = new ArrayList<>();
        HashMap<String,String>map=new HashMap<>();
        result=(List<Employees>) dao.employeeAuth(e.getEmail(),e.getPassword());
        if(result.size()==0)
        {
            map.put("failed","invalid credentials");
        }else {
            int id =result.get(0).getId();
            map.put("status","success");
            map.put("empid",String.valueOf(id));

        }
        map.put("status","success");
        return map;
    }
    @CrossOrigin(origins ="*")
    @PostMapping(path="/securityauth",consumes = "application/json",produces = "application/json")
    public HashMap<String,String>securityAuth(@RequestBody Security s)
    {
        List<Security> result= new ArrayList<>();
        HashMap<String,String>map = new HashMap<>();
        result=(List<Security>)sdao.securityAuth(s.getUsername(),s.getPassword());
        if(result.size()==0)
        {
            map.put("failed","invalid credentials");

        }else{
            int id = result.get(0).getId();
            map.put("status","success");
            map.put("sid",String.valueOf(id));

        }
        map.put("status","success");
        return map;
    }
    @CrossOrigin(origins = "*")
    @PostMapping(path="/leaveapplicationupdate",consumes = "application/json", produces ="application/json")
    public HashMap<String, String> updateLeaveApplication(@RequestBody  LeaveApplication la)
    {
        System.out.println(la.getStatus());
        ladao.updateLeaveApplication(la.getEmpid(),la.getStatus());
        HashMap<String,String> map = new HashMap<>();
        map.put("status","success");
        return map;
    }










}

