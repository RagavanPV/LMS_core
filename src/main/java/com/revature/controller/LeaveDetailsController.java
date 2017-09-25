package com.revature.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.revature.biz.impl.LeaveDetailsServiceImpl;
import com.revature.data.exception.DataServiceException;
import com.revature.model.Employee;
import com.revature.model.LeaveDetail;

@RestController
@RequestMapping("/leavedetail")
public class LeaveDetailsController {
    private static Logger logger = Logger.getLogger(LeaveDetailsController.class);

    @Autowired
    private LeaveDetailsServiceImpl leaveDetailsServiceImpl;
    
    @GetMapping("/")
    public List<LeaveDetail> getAllDepartment(){
        try {
            return leaveDetailsServiceImpl.getAll();
        } catch (DataServiceException e) {
            e.printStackTrace();
        }
        return null;
    }
    @GetMapping("/byempid")
    public List<LeaveDetail> getLeaveByEmployeeId(@RequestParam("empid")Integer empId){
        try {
            LeaveDetail detail=new LeaveDetail();
            Employee emp=new Employee();
            emp.setId(empId);
            detail.setEmployeeId(emp);
            return leaveDetailsServiceImpl.getLeaveByEmployeeId(detail);
        } catch (DataServiceException e) {
            e.printStackTrace();
        }
        return null;
    }
    @GetMapping("/myteam")
    public List<LeaveDetail> getEmpByManagerId(@RequestParam("userid") int managerId) {
        try {
            logger.info("Getting the Employee data...");
            return leaveDetailsServiceImpl.getEmpLeaveListByManagerId(managerId);
                    } catch (DataServiceException e) {
            e.printStackTrace();
        }
        return null;
}
    @GetMapping("/acceptleave")
    public int acceptLeave(@RequestParam("leaveid")int leaveId,@RequestParam("userid") int managerId) {
        try {
            logger.info("Getting the Employee data...");
            return leaveDetailsServiceImpl.acceptLeave(leaveId,managerId);
                    } catch (DataServiceException e) {
            e.printStackTrace();
        }
        return 0;
}
    @GetMapping("/rejectleave")
    public int rejectLeave(@RequestParam("leaveid")int leaveId,@RequestParam("userid") int managerId,@RequestParam("reason")String reason) {
        try {
            logger.info("Getting the Employee data...");
            return leaveDetailsServiceImpl.rejectLeave(leaveId,managerId,reason);
                    } catch (DataServiceException e) {
            e.printStackTrace();
        }
        return 0;
}
    @GetMapping("/cancelleave")
    public int rejectLeave(@RequestParam("leaveid")int leaveId) {
        try {
            logger.info("Getting the Employee data...");
            return leaveDetailsServiceImpl.cancelLeave(leaveId);
                    } catch (DataServiceException e) {
            e.printStackTrace();
        }
        return 0;
}

}