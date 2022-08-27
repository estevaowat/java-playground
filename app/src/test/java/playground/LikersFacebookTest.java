package playground;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LikersFacebookTest {

  @Test
  @DisplayName("should no one like this")
  void noOneLikesThis() {
    String result = LikersFacebook.whoLikesIt();
    Assertions.assertEquals("no one likes this", result);
  }

  @Test
  @DisplayName("should get 1 like from Peter")
  void peterLikes() {
    String result = LikersFacebook.whoLikesIt("Peter");
    Assertions.assertEquals("Peter likes this", result);
  }

  @Test
  @DisplayName("should get 2 likes in post from Jacob and Alex")
  void getLikesFromJacobAndAlex() {
    String result = LikersFacebook.whoLikesIt("Jacob", "Alex");
    Assertions.assertEquals("Jacob and Alex like this", result);
  }

  @Test
  @DisplayName("should get 3 likes")
  void get3LikesInPost() {
    String result = LikersFacebook.whoLikesIt("Max", "John", "Mark");
    Assertions.assertEquals("Max, John and Mark like this", result);
  }

  @Test
  @DisplayName("should get more than 3 likes")
  void getMoreThan3Likes() {
    String result = LikersFacebook.whoLikesIt("Alex", "Jacob", "Mark", "Max");
    Assertions.assertEquals("Alex, Jacob and 2 others like this", result);
  }
}
