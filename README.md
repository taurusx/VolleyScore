# VolleyScore App by [taurusx](https://taurusx.github.io/)

App preview (empty -> scored): 

![VolleyScore App Layout][screenshot-1]    ->    ![VolleyScore App Points][screenshot-2]

## General Description

Done as a part of [Android Basics Udacity's course][udacity-course]

An app that let's you count the points of two different teams gained during the game of your choice. I chose volleyball and applied all it's rules of scoring:
1. Game: team wins the game if 3 sets are won (min 3 sets when 3:0, maximum 5sets when 3:2).
2. Sets: team wins the set when 25 points are reached, __but__:
- if the last (5th) set is played, team needs 15 points instead of 25 to win the game;
- if there is a draw before regular last set point (24:24 or 14:14) the set is continued until one team reaches 2 points of winning margin (e.g. 27:29).
3. Points in the game can be gained during serve (if uninterrupted they are called 'aces'), regular attack, block or by opponents mistake (fauls). Winning team always get 1 point for each of those, the differentiation has only statistics reasons. 

The app __does not__ store the points.

## Main Goals

**Main Goals** of the task:
1. Variables' scopes (global/local)
2. Apply various mathematical logics (usage of `if/for/while`)
3. Simple interaction with an app (Button's `onClick` method)
4. Showing results of operation (displaying new score)

## Related Work

Check out my next app: [Quiz App][flowery-quiz].

[udacity-course]: https://eu.udacity.com/course/android-basics-nanodegree-by-google--nd803
[screenshot-1]: https://raw.githubusercontent.com/taurusx/volley-score/gh-pages/assets/images/volley-score-screenshot-1.png
[screenshot-2]: https://raw.githubusercontent.com/taurusx/volley-score/gh-pages/assets/images/volley-score-screenshot-2.png
[flowery-quiz]: https://github.com/taurusx/flowery-quiz

