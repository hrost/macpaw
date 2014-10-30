Scenario: Features page elements presentce

Given open main page
When go to features page
Then check URL equals to 'http://devmate.com/features/frameworks'
And screen shot for 'Sparkle-based Updates Framework' appears
When go to features page app management
Then check URL equals to 'http://devmate.com/features/app-management'
And screenshot for 'Easy Updates' appears