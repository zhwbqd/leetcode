# Write a SQL query to rank scores. If there is a tie between two scores, both should have the same ranking.
#Note that after a tie, the next ranking number should be the next consecutive integer value. In other words, there should be no "holes" between ranks.

# find the count greater or equals than itself
SELECT
  Score,
  (SELECT count(distinct Score) FROM Scores WHERE Score >= s.Score) Rank
FROM Scores s
ORDER BY Score desc;

# others, maybe more efficient
SELECT
  Score,
  @rank := @rank + (@prev <> (@prev := Score)) Rank
FROM
  Scores,
  (SELECT @rank := 0, @prev := -1) init
ORDER BY Score desc;

SELECT
  Score,
  (SELECT count(*) FROM (SELECT distinct Score s FROM Scores) tmp WHERE s >= Score) Rank
FROM Scores
ORDER BY Score desc;