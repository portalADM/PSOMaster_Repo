/************************************************************************************************************
 * Class Name : AdminPanelDAOImpl.java Description:
 * 
 * Author : Ankita Mishra Date : Apr 12, 2017 **********************************************************************************************************
 */
package com.zig.pso.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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

    private Connection portalDBConnection = null;

    public AdminPanelDAOImpl()
    {
        portalDBConnection = DBConnection.getPortalDBConnection();
    }

    @Override
    public BaseResponseBean addRemediationSteps(RemediationStepRequest remediationRequest)
    {
        BaseResponseBean remediationStepRes = new BaseResponseBean();
        String logRefID = CommonUtility.getLogRefID();
        String addSQL = null;
        String updateSQL = null;
        String deleteSQL = null;

        if ("ADD".equals(remediationRequest.getType()))
        {
            deleteSQL = OrderQueries.getDeleteRemediationStep();
            addSQL = OrderQueries.getInsertRemediationStep();
        }
        /*
         * else if ("UPDATE".equals(remediationRequest.getType())) { deleteSQL = OrderQueries.getDeleteRemediationStep(); updateSQL = OrderQueries.updateOrderSim(); }
         */
        else if ("DELETE".equals(remediationRequest.getType()))
            deleteSQL = OrderQueries.getDeleteRemediationStep();

        try
        {

            PreparedStatement pstm = portalDBConnection.prepareStatement(deleteSQL);
            PreparedStatement pstm2 = portalDBConnection.prepareStatement(addSQL);
            /*
             * int stepSize = remediationRequest.getRemediationSteps().size(); String abc = "";
             */
            /*
             * for (int k = 0; k <= stepSize - 1; k++) { abc = abc + remediationRequest.getRemediationSteps().get(k) + "@1"; pstm.setString(1, remediationRequest.getOrderStatus()); pstm.setString(2,
             * remediationRequest.getRemediationSteps().get(k)); pstm.addBatch(); } int[] i = pstm.executeBatch(); System.out.println(i[0]); remediationStepRes.setErrorCode(PSOConstants.SUCCESS_CODE);
             * remediationStepRes.setErrorMsg(PSOConstants.ORDER_UPDATE_SUCCESSFULL); remediationStepRes.setLogRefId(logRefID); PSOLoggerSrv.printSQL_DEBUG("AdminPanelDAOImpl", "addRemediationStep",
             * logRefID, sql, remediationRequest, remediationStepRes.getErrorMsg());
             */

            pstm.setString(1, remediationRequest.getOrderStatus());
            pstm.execute();
            pstm2.setString(1, remediationRequest.getOrderStatus());
            pstm2.setString(2, remediationRequest.getRemediationSteps());
            int i = pstm2.executeUpdate();
            System.out.println(i);
            if (i >= 0)
            {
                remediationStepRes.setErrorCode(PSOConstants.SUCCESS_CODE);
                remediationStepRes.setErrorMsg(PSOConstants.ORDER_UPDATE_SUCCESSFULL);
                remediationStepRes.setLogRefId(logRefID);
                PSOLoggerSrv.printSQL_DEBUG("AdminPanelDAOImpl", "addRemediationStep", logRefID, addSQL, remediationRequest, remediationStepRes.getErrorMsg());
            }

        }
        catch (SQLException e)
        {
            remediationStepRes.setErrorCode(PSOConstants.ERROR_CODE);
            remediationStepRes.setErrorMsg(PSOConstants.BACKEND_ERROR);
            remediationStepRes.setLogRefId(logRefID);
            System.out.println(e);
            e.printStackTrace();
            PSOLoggerSrv.printERROR("AdminPanelDAOImpl", "addRemediationSteps", logRefID, addSQL, remediationRequest, e);
        }

        return remediationStepRes;

    }
}
