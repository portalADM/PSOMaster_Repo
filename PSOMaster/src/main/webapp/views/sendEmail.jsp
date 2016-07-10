<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<div class="bs-docs-section">
        <div class="row">
          <div class="col-lg-12">
            <div class="page-header noPadBtm">
					<h3 id="navbar">
						<span class="glyphicon glyphicon-envelope marRight8"></span>Send Email
						<a href="#orderMaster" tooltip-placement="bottom" uib-tooltip="back"
							class="glyphicon glyphicon-chevron-left floatRight cursorPointer"></a>
					</h3>
				</div>
          </div>
        </div>

        <div class="row">
          <div class="col-lg-12">
            <div class="well bs-component">
              <form class="form-horizontal">
                <fieldset>
                  <div class="form-group">
                    <label for="inputEmail" class="col-lg-2 control-label">TO</label>
                    <div class="col-lg-10">
                      <input type="text" class="form-control col-lg-12" id="inputEmail" placeholder="Email" value='support@imm.com'>
                    </div>
                  </div>
                  <div class="form-group">
                    <label for="inputPassword" class="col-lg-2 control-label">CC</label>
                    <div class="col-lg-10">
                     <input type="text" class="form-control  col-lg-12" id="inputEmail" placeholder="Email" value='CricketPortalDevOGS@amdocs.com'>
                    </div>
                  </div>
                   <div class="form-group">
                    <label for="inputEmail" class="col-lg-2 control-label">Subject	</label>
                    <div class="col-lg-10">
                      <input type="text" class="form-control col-lg-12" id="inputEmail" >
                    </div>
                  </div>
                  <div class="form-group">
                    <label for="textArea" class="col-lg-2 control-label ">Message</label>
                    <div class="col-lg-10">
                      <textarea class="form-control" rows="18" cols="125" id="textArea"></textarea>
                    </div>
                  </div>
                 
                  <div class="form-group">
                    <div class="col-lg-10 col-lg-offset-2">
                     <!--  <button type="reset" class="btn btn-default">Cancel</button> -->
                      <button type="submit" class="btn btn-primary">Send</button>
                    </div>
                  </div>
                </fieldset>
              </form>
            </div>
          </div>
        </div>
      </div>

</body>
</html>