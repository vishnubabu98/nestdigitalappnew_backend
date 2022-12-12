package com.nest.nestdigitalappnew_backend.Controller;

import com.nest.nestdigitalappnew_backend.dao.EmployeeDao;
import com.nest.nestdigitalappnew_backend.dao.LeaveDao;
import com.nest.nestdigitalappnew_backend.dao.SecurityDao;
import com.nest.nestdigitalappnew_backend.model.Employees;
import com.nest.nestdigitalappnew_backend.model.Security;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
public class NestController {
    @Autowired
    private EmployeeDao dao;
    @Autowired
    private LeaveDao ldao;
    @Autowired
    private SecurityDao sdao;

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
    public HashMap<String,String>leaveCount(@RequestBody LeaveCount l)
    {
        System.out.println(l.getEmpcode());
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





    }

