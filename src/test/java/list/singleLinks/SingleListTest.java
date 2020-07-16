package list.singleLinks;

import list.List;
import org.junit.Test;
import static org.assertj.core.api.Assertions.*;

public class SingleListTest {

    @Test
    public void elementsInListShouldBeInCorrectOrderAfterAddedThemFromTheFront(){
        //given
        List<Integer> list = new SingleList<>();
        int element1 = 1;
        int element2 = 2;

        //when
        list.addFirst(element1);
        list.addFirst(element2);

        //then
        assertThat(list).containsExactly(element2, element1);
    }

    @Test
    public void shouldThrowIllegalArgumentExceptionWhenNullIsAddedFromTheFront(){
        //given
        List<Integer> list = new SingleList<>();

        //then
        assertThatIllegalArgumentException().isThrownBy(() -> list.addFirst(null));
    }

    @Test
    public void elementsInListShouldBeInCorrectOrderAfterAddedThemFromTheBack(){
        //given
        List<Integer> list = new SingleList<>();
        int element1 = 1;
        int element2 = 2;

        //when
        list.addLast(element1);
        list.addLast(element2);

        //then
        assertThat(list).containsExactly(element1, element2);
    }

    @Test
    public void shouldThrowIllegalArgumentExceptionWhenNullIsAddedFromTheBack(){
        //given
        List<Integer> list = new SingleList<>();

        //then
        assertThatIllegalArgumentException().isThrownBy(() -> list.addLast(null));
    }

    @Test
    public void listShouldHaveCorrectSizeAfterAddingElements(){
        //given
        List<Integer> list = new SingleList<>();
        int element1 = 1;
        int element2 = 2;

        //when
        list.addLast(element1);
        list.addFirst(element2);

        //then
        assertThat(list).hasSize(2);
    }

    @Test
    public void listShouldHaveCorrectSizeAfterRemovingElement(){
        //given
        List<Integer> list = new SingleList<>();
        list.addLast(1);
        list.addFirst(2);

        //when
        list.remove(1);

        //then
        assertThat(list).hasSize(1);
    }

    @Test
    public void listShouldHaveCorrectSizeAfterRemovingElementFromFront(){
        //given
        List<Integer> list = new SingleList<>();
        list.addLast(1);
        list.addFirst(2);

        //when
        list.removeFirst();

        //then
        assertThat(list).hasSize(1);
    }

    @Test
    public void listShouldHaveCorrectSizeAfterRemovingElementFromBack(){
        //given
        List<Integer> list = new SingleList<>();
        list.addLast(1);
        list.addFirst(2);

        //when
        list.removeLast();

        //then
        assertThat(list).hasSize(1);
    }

    @Test
    public void listShouldNotContainRemovedElement(){
        //given
        List<Integer> list = new SingleList<>();
        int element1 = 1;
        int element2 = 2;
        list.addLast(element1);
        list.addFirst(element2);

        //when
        list.remove(element1);

        //then
        assertThat(list).containsExactly(element2);
    }

    @Test
    public void listShouldNotContainRemovedElementFromTheFront(){
        //given
        List<Integer> list = new SingleList<>();
        int element1 = 1;
        int element2 = 2;
        list.addFirst(element1);
        list.addFirst(element2);

        //when
        list.removeFirst();

        //then
        assertThat(list).containsExactly(element1);
    }

    @Test
    public void listShouldNotContainRemovedElementFromTheBack(){
        //given
        List<Integer> list = new SingleList<>();
        int element1 = 1;
        int element2 = 2;
        list.addFirst(element1);
        list.addFirst(element2);

        //when
        list.removeLast();

        //then
        assertThat(list).containsExactly(element2);
    }

    @Test
    public void removalShouldReturnFalseWhenListIsEmpty(){
        //given
        List<Integer> list = new SingleList<>();

        //when
        boolean result = list.remove(0);

        //then
        assertThat(result).isFalse();
    }

    @Test
    public void removeLastMethodShouldReturnFalseWhenListIsEmpty(){
        //given
        List<Integer> list = new SingleList<>();

        //when
        boolean result = list.removeLast();

        //then
        assertThat(result).isFalse();
    }

    @Test
    public void removeFirstMethodShouldReturnFalseWhenListIsEmpty(){
        //given
        List<Integer> list = new SingleList<>();

        //when
        boolean result = list.removeFirst();

        //then
        assertThat(result).isFalse();
    }

    @Test
    public void removalShouldReturnFalseWhenListNotContainElement(){
        //given
        List<Integer> list = new SingleList<>();
        list.addFirst(1);

        //when
        boolean result = list.remove(2);

        //then
        assertThat(result).isFalse();
    }

    @Test
    public void listShouldBeEmptyAfterRemoveLastElement(){
        //given
        List<Integer> list = new SingleList<>();
        list.addFirst(1);

        //when
        list.remove(1);

        //then
        assertThat(list).isEmpty();
    }

    @Test
    public void listShouldBeEmptyAfterRemoveLastElementUsingFrontRemoveMethod(){
        //given
        List<Integer> list = new SingleList<>();
        list.addFirst(1);

        //when
        list.removeFirst();

        //then
        assertThat(list).isEmpty();
    }

    @Test
    public void listShouldBeEmptyAfterRemoveLastElementUsingBackRemoveMethod(){
        //given
        List<Integer> list = new SingleList<>();
        list.addFirst(1);

        //when
        list.removeLast();

        //then
        assertThat(list).isEmpty();
    }

    @Test
    public void minElementShouldBeChangedAfterRemoveActualMinElement(){
        //given
        List<Integer> list = new SingleList<>();
        list.addFirst(1);
        list.addFirst(10);

        //when
        list.remove(1);
        int minElement = list.getMin();

        //then
        assertThat(minElement).isEqualTo(10);
    }

    @Test
    public void maxElementShouldBeChangedAfterRemoveActualMaxElement(){
        //given
        List<Integer> list = new SingleList<>();
        list.addFirst(1);
        list.addFirst(10);

        //when
        list.remove(1);
        int maxElement = list.getMax();

        //then
        assertThat(maxElement).isEqualTo(10);
    }

    @Test
    public void minElementShouldBeChangedAfterRemoveActualMinElementUsingRemoveFirstMethod(){
        //given
        List<Integer> list = new SingleList<>();
        list.addFirst(1);
        list.addFirst(10);

        //when
        list.removeFirst();
        int minElement = list.getMin();

        //then
        assertThat(minElement).isEqualTo(1);
    }

    @Test
    public void minElementShouldBeChangedAfterRemoveActualMinElementUsingRemoveLastMethod(){
        //given
        List<Integer> list = new SingleList<>();
        list.addFirst(1);
        list.addFirst(10);

        //when
        list.removeLast();
        int minElement = list.getMin();

        //then
        assertThat(minElement).isEqualTo(10);
    }

    @Test
    public void maxElementShouldBeChangedAfterRemoveActualMaxElementUsingRemoveFirstMethod(){
        //given
        List<Integer> list = new SingleList<>();
        list.addFirst(1);
        list.addFirst(10);

        //when
        list.removeFirst();
        int maxElement = list.getMax();

        //then
        assertThat(maxElement).isEqualTo(1);
    }

    @Test
    public void maxElementShouldBeChangedAfterRemoveActualMaxElementUsingRemoveLastMethod(){
        //given
        List<Integer> list = new SingleList<>();
        list.addFirst(1);
        list.addFirst(10);

        //when
        list.removeLast();
        int maxElement = list.getMax();

        //then
        assertThat(maxElement).isEqualTo(10);
    }

    @Test
    public void theHeadPointerShouldBeUpdatedAfterRemovingActualHead(){
        //given
        SingleList<Integer> list = new SingleList<>();
        list.addFirst(10);
        list.addFirst(15);
        Node<Integer> headBeforeRemoving = list.getHead();

        //when
        list.remove(15);
        Node<Integer> headAfterRemoving = list.getHead();

        //then
        assertThat(headBeforeRemoving).isNotSameAs(headAfterRemoving);
        assertThat(headAfterRemoving.getElement()).isEqualTo(10);
    }

    @Test
    public void removeMethodShouldReturnFalseWhenListNotContainRemovingElement(){
        //given
        List<Integer> list = new SingleList<>();
        list.addFirst(1);
        list.addFirst(10);

        //when
        boolean result = list.remove(0);

        //then
        assertThat(result).isFalse();
    }

    @Test
    public void listShouldNotHaveMinElementWhenIsEmpty(){
        //given
        List<Integer> list = new SingleList<>();

        //when
        Integer min = list.getMin();

        //then
        assertThat(min).isNull();
    }

    @Test
    public void listShouldNotHaveMaxElementWhenIsEmpty(){
        //given
        List<Integer> list = new SingleList<>();

        //when
        Integer max = list.getMax();

        //then
        assertThat(max).isNull();
    }

    @Test
    public void shouldReturnTrueWhenListContainsElement(){
        //given
        List<Integer> list = new SingleList<>();
        list.addFirst(5);
        list.addLast(-12);

        //when
        boolean result = list.contains(5);

        //then
        assertThat(result).isTrue();
    }

    @Test
    public void shouldReturnFalseWhenListContainsElement(){
        //given
        List<Integer> list = new SingleList<>();
        list.addFirst(5);
        list.addLast(-12);

        //when
        boolean result = list.contains(6);

        //then
        assertThat(result).isFalse();
    }

    @Test
    public void headPointerShouldBeNullAfterClearingTheList(){
        //given
        SingleList<Integer> list = new SingleList<>();
        list.addFirst(5);
        list.addLast(-12);

        //when
        list.clear();

        //then
        assertThat(list.getHead()).isNull();
    }

    @Test
    public void minValueShouldBeNullAfterClearingTheList(){
        //given
        SingleList<Integer> list = new SingleList<>();
        list.addFirst(5);
        list.addLast(-12);

        //when
        list.clear();

        //then
        assertThat(list.getMin()).isNull();
    }

    @Test
    public void maxValueShouldBeNullAfterClearingTheList(){
        //given
        SingleList<Integer> list = new SingleList<>();
        list.addFirst(5);
        list.addLast(-12);

        //when
        list.clear();

        //then
        assertThat(list.getMax()).isNull();
    }

    @Test
    public void shouldThrowIllegalArgumentExceptionWhenGivenArrayOfListElementsIsTooSmall(){
        //given
        SingleList<Integer> list = new SingleList<>();
        list.addFirst(5);
        list.addLast(-12);
        Integer[] resultTab = new Integer[1];

        //then
        assertThatIllegalArgumentException().isThrownBy(() -> list.toArray(resultTab));
    }

    @Test
    public void resultArrayOfListElementsShouldContainTheSameElementsAsList(){
        //given
        SingleList<Integer> list = new SingleList<>();
        int element1 = 5;
        int element2 = -12;
        list.addFirst(element1);
        list.addLast(element2);
        Integer[] resultTab = new Integer[list.size()];

        //given
        resultTab = list.toArray(resultTab);

        //then
        assertThat(resultTab).contains(element2, element1);
    }

    @Test
    public void resultArrayOfListElementsShouldHaveTheSameElementsOrderAsList(){
        //given
        SingleList<Integer> list = new SingleList<>();
        int element1 = 5;
        int element2 = -12;
        list.addFirst(element1);
        list.addFirst(element2);
        Integer[] resultTab = new Integer[list.size()];

        //given
        resultTab = list.toArray(resultTab);

        //then
        assertThat(resultTab).containsExactly(element2, element1);
    }

    @Test
    public void resultArrayOfListElementsShouldHaveTheSameSizeAsList(){
        //given
        SingleList<Integer> list = new SingleList<>();
        int element1 = 5;
        int element2 = -12;
        list.addFirst(element1);
        list.addFirst(element2);
        Integer[] resultTab = new Integer[list.size()];
        resultTab = list.toArray(resultTab);

        //given
        int arraySize = resultTab.length;

        //then
        assertThat(arraySize).isEqualTo(list.size());
    }

    @Test
    public void getMethodShouldThrowIndexOutOfBoundsExceptionWhenIndexIsOutOfBound(){
        //given
        SingleList<Integer> list = new SingleList<>();
        list.addFirst(5);
        list.addLast(-12);

        //then
        assertThatExceptionOfType(IndexOutOfBoundsException.class).isThrownBy(() -> list.get(2));
    }

    @Test
    public void getMethodShouldReturnNullWhenListIsEmpty(){
        //given
        SingleList<Integer> list = new SingleList<>();

        //then
        Integer element = list.get(0);

        //then
        assertThat(element).isNull();
    }

    @Test
    public void getMethodShouldReturnCorrectValue(){
        //given
        SingleList<Integer> list = new SingleList<>();
        list.addFirst(1);
        list.addFirst(10);

        //then
        int result = list.get(0);

        //then
        assertThat(result).isEqualTo(10);
    }

    @Test
    public void getFirstElementMethodShouldReturnNullWhenListIsEmpty(){
        //given
        SingleList<Integer> list = new SingleList<>();

        //then
        Integer result = list.getFirst();

        //then
        assertThat(result).isNull();
    }

    @Test
    public void getFirstElementMethodShouldReturnHead(){
        //given
        SingleList<Integer> list = new SingleList<>();
        list.addFirst(10);
        list.addFirst(12);
        Node<Integer> head = list.getHead();

        //then
        Integer result = list.getFirst();

        //then
        assertThat(result).isSameAs(head.getElement());
    }

    @Test
    public void getLastElementMethodShouldReturnNullWhenListIsEmpty(){
        //given
        SingleList<Integer> list = new SingleList<>();

        //then
        Integer result = list.getLast();

        //then
        assertThat(result).isNull();
    }

    @Test
    public void getLastElementMethodShouldReturnLastElementInList(){
        //given
        SingleList<Integer> list = new SingleList<>();
        list.addFirst(10);
        list.addFirst(12);
        int lastElementInList = list.get(list.size() - 1);

        //then
        Integer result = list.getLast();

        //then
        assertThat(result).isSameAs(lastElementInList);
    }

    @Test
    public void setValueMethodShouldThrowIndexOutOfBoundsExceptionWhenIndexIsOutOfBound(){
        //given
        List<Integer> list = new SingleList<>();
        list.addFirst(10);

        //then
        assertThatExceptionOfType(IndexOutOfBoundsException.class).isThrownBy(() -> list.setValue(5, 20));
    }

    @Test
    public void setValueMethodShouldReturnFalseWhenListIsEmpty(){
        //given
        List<Integer> list = new SingleList<>();

        //when
        boolean result = list.setValue(0, 12);

        //then
        assertThat(result).isFalse();
    }

    @Test
    public void setValueMethodShouldReturnTrueWhenValueWasChanged(){
        //given
        List<Integer> list = new SingleList<>();
        list.addFirst(10);
        list.addFirst(20);

        //when
        boolean result = list.setValue(0, 12);

        //then
        assertThat(result).isTrue();
    }

    @Test
    public void setValueMethodShouldChangeTheOldValueToTheNewOne(){
        //given
        List<Integer> list = new SingleList<>();
        int oldValue = 10;
        int newValue = 12;
        list.addFirst(oldValue);

        //when
        list.setValue(0, newValue);
        int result = list.get(0);

        //then
        assertThat(newValue).isEqualTo(result);
    }

    @Test
    public void toStringMethodShouldWriteMethodFromTheHeadToTheTail(){
        //given
        SingleList<Integer> list = new SingleList<>();
        list.addFirst(10);
        list.addFirst(12);

        //then
        String result = list.toString();

        //then
        assertThat(result).isEqualTo("12 10");
    }
}