package pl.mobly.domain;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.observers.TestObserver;
import io.reactivex.subscribers.TestSubscriber;

import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
public class LoadInstalledAppsUseCaseTest {

    LoadInstalledAppsUseCase systemUnderTest;

    @Mock
    SystemApi systemApi;

    @Mock
    List fakeList;

    @Before
    public void setUp() throws Exception {
        systemUnderTest = new LoadInstalledAppsUseCase(systemApi);
    }

    @Test
    public void assumeCanLoadListOfApps() throws Exception {
        simulateApiResponded();

        TestObserver<List> testObserver = TestObserver.create();
        systemUnderTest.buildUseCase(null).subscribe(testObserver);
        testObserver.assertComplete();
        testObserver.assertNoErrors();
    }

    private void simulateApiResponded() {
        when(systemApi.loadAppsList()).thenReturn(Observable.fromArray(fakeList));
    }


}