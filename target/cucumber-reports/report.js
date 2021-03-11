$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/features/CRUD_Operations.feature");
formatter.feature({
  "name": "CRUD operations",
  "description": "  This feature will help users to understand the CRUD operations of api.",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@CRUDoperations"
    }
  ]
});
formatter.scenarioOutline({
  "name": "Creating a new record in the database",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@postapicall"
    }
  ]
});
formatter.step({
  "name": "We have the \"\u003capi\u003e\" url",
  "keyword": "Given "
});
formatter.step({
  "name": "A record is created \"\u003cstatus\u003e\"",
  "keyword": "When "
});
formatter.step({
  "name": "The response \u003ccode\u003e is shown",
  "keyword": "Then "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "api",
        "status",
        "code"
      ]
    },
    {
      "cells": [
        "POST",
        "successful",
        "201"
      ]
    }
  ]
});
formatter.scenario({
  "name": "Creating a new record in the database",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@CRUDoperations"
    },
    {
      "name": "@postapicall"
    }
  ]
});
formatter.step({
  "name": "We have the \"POST\" url",
  "keyword": "Given "
});
formatter.match({
  "location": "ApiSteps.weHaveTheApi(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "A record is created \"successful\"",
  "keyword": "When "
});
formatter.match({
  "location": "ApiSteps.aRecordIsCreated(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "The response 201 is shown",
  "keyword": "Then "
});
formatter.match({
  "location": "ApiSteps.theResponseIsShown(int)"
});
formatter.result({
  "status": "passed"
});
formatter.scenarioOutline({
  "name": "Updating an existing record in the database.",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@putapicall"
    }
  ]
});
formatter.step({
  "name": "We have the \"\u003capi\u003e\" url",
  "keyword": "Given "
});
formatter.step({
  "name": "A \u003crecord\u003e is updated \"\u003cstatus\u003e\"",
  "keyword": "When "
});
formatter.step({
  "name": "The response \u003ccode\u003e is shown",
  "keyword": "Then "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "api",
        "status",
        "code",
        "record"
      ]
    },
    {
      "cells": [
        "PUT",
        "successful",
        "200",
        "10"
      ]
    },
    {
      "cells": [
        "PUT",
        "unsuccessful",
        "500",
        "400"
      ]
    }
  ]
});
formatter.scenario({
  "name": "Updating an existing record in the database.",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@CRUDoperations"
    },
    {
      "name": "@putapicall"
    }
  ]
});
formatter.step({
  "name": "We have the \"PUT\" url",
  "keyword": "Given "
});
formatter.match({
  "location": "ApiSteps.weHaveTheApi(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "A 10 is updated \"successful\"",
  "keyword": "When "
});
formatter.match({
  "location": "ApiSteps.aRecordIsUpdated(int,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "The response 200 is shown",
  "keyword": "Then "
});
formatter.match({
  "location": "ApiSteps.theResponseIsShown(int)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Updating an existing record in the database.",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@CRUDoperations"
    },
    {
      "name": "@putapicall"
    }
  ]
});
formatter.step({
  "name": "We have the \"PUT\" url",
  "keyword": "Given "
});
formatter.match({
  "location": "ApiSteps.weHaveTheApi(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "A 400 is updated \"unsuccessful\"",
  "keyword": "When "
});
formatter.match({
  "location": "ApiSteps.aRecordIsUpdated(int,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "The response 500 is shown",
  "keyword": "Then "
});
formatter.match({
  "location": "ApiSteps.theResponseIsShown(int)"
});
formatter.result({
  "status": "passed"
});
formatter.scenarioOutline({
  "name": "Accessing the details from the database, of a particular record.",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@getapicall"
    }
  ]
});
formatter.step({
  "name": "We have the \"GET\" url",
  "keyword": "Given "
});
formatter.step({
  "name": "We can access the details of the \u003crecord\u003e successfully",
  "keyword": "Then "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "record"
      ]
    },
    {
      "cells": [
        "10"
      ]
    },
    {
      "cells": [
        "1"
      ]
    }
  ]
});
formatter.scenario({
  "name": "Accessing the details from the database, of a particular record.",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@CRUDoperations"
    },
    {
      "name": "@getapicall"
    }
  ]
});
formatter.step({
  "name": "We have the \"GET\" url",
  "keyword": "Given "
});
formatter.match({
  "location": "ApiSteps.weHaveTheApi(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "We can access the details of the 10 successfully",
  "keyword": "Then "
});
formatter.match({
  "location": "ApiSteps.weCanAccessTheDetailsSuccessfully(int)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Accessing the details from the database, of a particular record.",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@CRUDoperations"
    },
    {
      "name": "@getapicall"
    }
  ]
});
formatter.step({
  "name": "We have the \"GET\" url",
  "keyword": "Given "
});
formatter.match({
  "location": "ApiSteps.weHaveTheApi(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "We can access the details of the 1 successfully",
  "keyword": "Then "
});
formatter.match({
  "location": "ApiSteps.weCanAccessTheDetailsSuccessfully(int)"
});
formatter.result({
  "status": "passed"
});
formatter.scenarioOutline({
  "name": "Deleting a particular record from the database",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@deleteapicall"
    }
  ]
});
formatter.step({
  "name": "We have the \"DELETE\" url",
  "keyword": "Given "
});
formatter.step({
  "name": "We can delete the \u003crecord\u003e successfully",
  "keyword": "Then "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "record"
      ]
    },
    {
      "cells": [
        "10"
      ]
    },
    {
      "cells": [
        "1"
      ]
    }
  ]
});
formatter.scenario({
  "name": "Deleting a particular record from the database",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@CRUDoperations"
    },
    {
      "name": "@deleteapicall"
    }
  ]
});
formatter.step({
  "name": "We have the \"DELETE\" url",
  "keyword": "Given "
});
formatter.match({
  "location": "ApiSteps.weHaveTheApi(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "We can delete the 10 successfully",
  "keyword": "Then "
});
formatter.match({
  "location": "ApiSteps.weCanDeleteTheRecordSuccessfully(int)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Deleting a particular record from the database",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@CRUDoperations"
    },
    {
      "name": "@deleteapicall"
    }
  ]
});
formatter.step({
  "name": "We have the \"DELETE\" url",
  "keyword": "Given "
});
formatter.match({
  "location": "ApiSteps.weHaveTheApi(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "We can delete the 1 successfully",
  "keyword": "Then "
});
formatter.match({
  "location": "ApiSteps.weCanDeleteTheRecordSuccessfully(int)"
});
formatter.result({
  "status": "passed"
});
});