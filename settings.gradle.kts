include("order-api")
include("order-common")
include("order-domain")
include("order-usecase")
include("order-outgoing-adapter")
project(":order-api").projectDir = file("order-incoming-adapter/order-api")
