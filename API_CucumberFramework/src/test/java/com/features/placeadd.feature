
Feature: Validating Place add API's
  @AddPlaceAndDelete
Scenario Outline: TC to Validate the place is added using addAPI
  Given Add place payload as <Accuracy> <Address> <Name> <PhoneNumber> <Shoe> <Shop> <Latitude> <Langitude>
  When user uses the post method when "createRequest" as "Post"
#  Then verify if the place is added by getting the "status" as "OK"
  Then verify JsonResponse based on HttpRequest as "Post"
  And verify the place is added by using "get" request when "getRequest" the name should be <Name>
  And change the Address by using "putRequest" Request as "Put"
  And Delete the location that we added using "deleteRequest" as "Delete"
  Examples:
    |Accuracy  | Address         | Name   | PhoneNumber           |Shoe            |Shop      |Latitude |Langitude|
    |  "24"      | "27 mandana post" | "Bharani"| "+7239802906"   |"Books"         |"Showroom"|-67.08975|67.08975 |
    |  "20"      | "12 mandana post" | "Vignesh"| "+7287904764"   |"Playstation"   |"Showroom"|-45.08975|45.08975 |