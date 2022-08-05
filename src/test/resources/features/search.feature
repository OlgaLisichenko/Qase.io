Feature: Site search

  Background: Login
    Given User logs in

  Scenario Outline: Search for a project by full and partial project name
    When User searches for <projectName>
    Then <projectNameResult> is in the search results

    Examples:
      | projectName    | projectNameResult |
      | "Demo Project" | "Demo Project"    |
      | "Demo"         | "Demo Project"    |
      | "Project"      | "Demo Project"    |
      | "De"           | "Demo Project"    |

  Scenario Outline: Search for cases in the project
    Given User is on the "Demo Project" repository page
    When User does search by <caseName>
    Then <caseNameResult> is in the search result

    Examples:
      | caseName         | caseNameResult   |
      | "Authorization"  | "Authorization"  |
      | "Delete project" | "Delete project" |