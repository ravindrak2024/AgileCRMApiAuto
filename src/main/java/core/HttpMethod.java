package core;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.log4j.Logger;
import utilities.LogInitilizer;
import utilities.RestAssuredRequestFilter;

public enum HttpMethod {
  GET {
    public Response execute(RequestSpecBuilder request) {
      Logger log=LogInitilizer.getLogger();
      return this.getSpec(request).get();
    }
  },
  POST {
    public Response execute(RequestSpecBuilder request) {
      return (Response)this.getSpec(request).post();
    }
  },
  PUT {
    public Response execute(RequestSpecBuilder request) {
      return (Response)this.getSpec(request).put();
    }
  },
  DELETE {
    public Response execute(RequestSpecBuilder request) {
      return (Response)this.getSpec(request).delete();
    }
  },
  PATCH {
    public Response execute(RequestSpecBuilder request) {
      return (Response)this.getSpec(request).patch();
    }
  };

  private HttpMethod() {
  }

  public RequestSpecification getSpec(RequestSpecBuilder request) {
    request.log(LogDetail.ALL);
    request.addFilter(new RestAssuredRequestFilter());
    RequestSpecification spec = RestAssured.given().spec(request.build());
    return spec;
  }

  public abstract Response execute(RequestSpecBuilder var1);
}
