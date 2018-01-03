/************************************************************************************************************
 * Class Name : AdminPanelDAOImpl.java 
 * Description: 
 * Author : Ankita Mishra  
 * Date : Apr 12, 2017 
 * **********************************************************************************************************  --------------------------------
 * Modified by : Nilesh Patil
 * Date : Nov 29, 2017
 * Description : Fixed Sonar Bugs 
 * **********************************************************************************************************
 */
package com.zig.pso.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.zig.pso.constants.PSOConstants;
import com.zig.pso.logging.PSOLoggerSrv;
import com.zig.pso.rest.bean.BaseResponseBean;
import com.zig.pso.rest.bean.RemediationStepRequest;
import com.zig.pso.utility.CommonUtility;
import com.zig.pso.utility.DBConnection;
import com.zig.pso.utility.OrderQueries;


/**
 * 
 */
@Repository
public class AdminPanelDAOImpl implements AdminPanelDAO
{
    static final Logger logger = Logger.getLogger(AdminPanelDAOImpl.class);
    
    public static final String CLASS_NAME = "AdminPanelDAOImpl";
    public static final String ADD_REM_STEP = "addRemediationStep";
    
    private Connection getPortalDbConnction()
    {
        return DBConnection.getPortalDBConnection();
    }

    @Override
    public BaseResponseBean addRemediationSteps(RemediationStepRequest remediationRequest)
    {
        BaseResponseBean remediationStepRes = new BaseResponseBean();
        String logRefID = CommonUtility.getLogRefID();
        String addSQL = null;
        String deleteSQL = null;
        
        Connection con = this.getPortalDbConnction();

        if ("ADD".equals(remediationRequest.getType()))
        {
            deleteSQL = OrderQueries.getDeleteRemediationStep();
            addSQL = OrderQueries.getInsertRemediationStep();
        }
        else if ("DELETE".equals(remediationRequest.getType()))
            deleteSQL = OrderQueries.getDeleteRemediationStep();

        PreparedStatement pstm = null;
        PreparedStatement pstm2 = null;
        
        
        try
        {

            pstm = con.prepareStatement(deleteSQL);
            pstm2 = con.prepareStatement(addSQL);

            pstm.setString(1, remediationRequest.getOrderStatus());
            pstm.execute();
            pstm2.setString(1, remediationRequest.getOrderStatus());
            pstm2.setString(2, remediationRequest.getRemediationSteps());
            int i = pstm2.executeUpdate();
            if (i >= 0)
            {
                remediationStepRes.setErrorCode(PSOConstants.SUCCESS_CODE);
                remediationStepRes.setErrorMsg(PSOConstants.ORDER_UPDATE_SUCCESSFULL);
                remediationStepRes.setLogRefId(logRefID);
                PSOLoggerSrv.printSQL_DEBUG(logger,CLASS_NAME, ADD_REM_STEP, logRefID, addSQL, remediationRequest, remediationStepRes.getErrorMsg());
            }

        }
        catch (SQLException e)
        {
            remediationStepRes.setErrorCode(PSOConstants.ERROR_CODE);
            remediationStepRes.setErrorMsg(PSOConstants.BACKEND_ERROR);
            remediationStepRes.setLogRefId(logRefID);
            PSOLoggerSrv.printERROR(logger,CLASS_NAME, ADD_REM_STEP, e);
        }
        finally
        {
            try
            {
                con.close();
            }
            catch (SQLException e)
            {
                PSOLoggerSrv.printERROR(logger,CLASS_NAME, ADD_REM_STEP, e);
            }
            if (pstm != null)
            {
                try
                {
                    pstm.close();
                }
                catch (SQLException e)
                {
                    PSOLoggerSrv.printERROR(logger,CLASS_NAME, ADD_REM_STEP, e);
                }
            }
            if (pstm2 != null)
            {
                try
                {
                    pstm2.close();
                }
                catch (SQLException e)
                {
                    PSOLoggerSrv.printERROR(logger,CLASS_NAME, ADD_REM_STEP, e);
                }
            }
        }
        

        return remediationStepRes;

    }
}
