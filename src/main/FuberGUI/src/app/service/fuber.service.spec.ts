import { TestBed, inject } from '@angular/core/testing';

import { FuberService } from './fuber.service';

describe('FuberService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [FuberService]
    });
  });

  it('should be created', inject([FuberService], (service: FuberService) => {
    expect(service).toBeTruthy();
  }));
});
