# Git commit message convention

## Format of the commit message:

```
<type>(<scope>): <subject>

<body>
```

All lines are wrapped at 100 characters !

### Example commit message:

```
fix(middleware): ensure Range headers adhere more closely to RFC 2616

Add one new dependency, use `range-parser` (Express dependency) to compute
range. It is more well-tested in the wild.

Fixes #2310
```

## Message subject (first line)

The first line cannot be longer than 70 characters, the second line is always blank and other lines should be wrapped at 80 characters. The type and scope should always be lowercase as shown below.

### Allowed `<type>`

* feat (new feature for the user, not a new feature for build script)
* fix (bug fix for the user, not a fix to a build script)
* docs (changes to the documentation)
* style (formatting, missing semi colons, etc; no production code change)
* refactor (refactoring production code, eg. renaming a variable)
* test (adding missing tests, refactoring tests; no production code change)
* chore (updating build tasks, etc; no production code change)

### Allowed `<scope>`:

Scope could be anything specifying place of the commit change. For example controller, service, config, proxy, etc...

### Breaking changes

All breaking changes have to be mentioned in message body, on separated line:

```
Breaks removed $browser.setUrl() method (use $browser.url(newUrl))
Breaks ng:repeat option is no longer supported on selects (use ng:options)
```

## Message body

uses the imperative, present tense: “change” not “changed” nor “changes”
includes motivation for the change and contrasts with previous behavior
