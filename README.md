# codereviewer-jira

A small demo of how industry teams use **Jira + GitHub together**, built on the
CSE2024 Code Review Lab file `CodeReviewEx.java`.

- **Jira** (space `KAN`) tracks the work: what is wrong, who owns it, how urgent, and its status.
- **GitHub** holds the code: branches, commits, pull requests, automated checks and code review.
- The **Jira key** (e.g. `KAN-9`) in every branch, commit and PR title links the two.

## The workflow

| Step | Where | What happens | Jira status |
|---|---|---|---|
| 1 | Jira | A reviewer logs each finding as a ticket (steps, expected, actual) | To Do |
| 2 | GitHub | Developer creates a branch named after the ticket: `fix/KAN-6-...` | In Progress |
| 3 | GitHub | Small commits, each starting with the key: `KAN-6 Add missing import` | In Progress |
| 4 | GitHub | Pull request opened; CI compiles and runs tests automatically | In Review |
| 5 | GitHub | Another person reviews the diff, comments, asks for changes | In Review |
| 6 | GitHub | Author pushes a follow-up commit answering the review | In Review |
| 7 | GitHub | Approved PR is merged into `main` (merge commit keeps everyone's authorship) | Done |

## Tickets and pull requests

| Jira | Problem | Branch |
|---|---|---|
| KAN-6 | Does not compile (missing `java.util.List` import) | `fix/KAN-6-missing-list-import` |
| KAN-9, KAN-10, KAN-11, KAN-14 | `leap()` wrong for '5', for 2000, crashes under 1000 | `fix/KAN-14-leap-year-rule` |
| KAN-7, KAN-8, KAN-12, KAN-13 | `dayOfYear()` wrong for Sep–Nov and leap years; magic numbers; no validation | `fix/KAN-7-day-of-year` |
| KAN-15 | `countLongWords()` uses global state and prints instead of returning | `refactor/KAN-15-count-long-words` |

`main` starts with the original, buggy file, so the first CI run on `main` is **red**.
Each merged PR turns more of it green.

## Run locally

```bash
mkdir -p out
javac -d out src/*.java test/*.java
java -cp out CodeReviewExTest
```
